package org.example.utill;

import org.example.domain.Enemy;
import org.example.domain.Pokemon;
import org.example.domain.Psyduck;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MiniGameHandler {

    private static final Random random = new Random();

    private static final int INTERVAL = 100;        //공격 시도 간 대기시간
    private static final int ATTACK_TIMEOUT  = 3000;    //공격 시도 가능 시간(만료 시 공격)
    private static final int ATTACK_PROBABILITY_THRESHOLD = 30; //랜덤 생성 값이 이 값 넘으면 공격 성공

    public static void start(Pokemon playerPokemon) {

        Enemy enemy = new Enemy(playerPokemon.getExp()*5 + 100);   //적의 체력은 플레이어 포켓몬의 경험치와 비례해서 증가.
        int rivalExp = random.nextInt(10, playerPokemon.getExp() + 50);
        Psyduck rival = new Psyduck("고라파덕", rivalExp, 0);

        System.out.println("\n===== 미니게임 시작! =====");
        System.out.println("적 HP: " + enemy.getHp());
        System.out.println(playerPokemon.getName() + " vs " + rival.getName());
        System.out.println("==========================\n");
        SleepUtill.sleep(1000);

        // 스레드 2개: 플레이어, 경쟁자
        ExecutorService executor = Executors.newFixedThreadPool(2); //플레이어와 경쟁자 스레드 2개 존재

        Future<?> playerFuture = executor.submit(() -> runAttackLoop(playerPokemon, enemy, true));
        Future<?> rivalFuture  = executor.submit(() -> runAttackLoop(rival, enemy, false));
        //두 스레드가 각자 공격 루프를 돌고, Future 객체를 반환하고, 두 스레드가 모두 끝날 때까지 대기.
        //반환값이 있으므로 submit()을 사용하여 동작.
        try {
            playerFuture.get();
            rivalFuture.get(); // 두 공격 스레드가 끝날 때까지 대기
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
        }

        executor.shutdown(); // 스레드 모두 종료

        System.out.println("\n===== 전투 종료! =====");
        if (enemy.isPlayerWon()) {
            System.out.println(playerPokemon.getName() + "이(가) 적을 쓰러뜨렸습니다! 승리!");
            System.out.println("애정도와 경험치가 80 증가합니다!");
            playerPokemon.setExp(playerPokemon.getExp() + 80);
            playerPokemon.setAffection(playerPokemon.getAffection() + 80);

        } else {
            System.out.println(rival.getName() + "이(가) 적을 쓰러뜨렸습니다. 패배...");
            System.out.println("애정도가 50 하락했습니다");
            playerPokemon.setAffection(playerPokemon.getAffection() - 50);
        }
    }

    private static void runAttackLoop(Pokemon attacker, Enemy enemy, boolean isPlayer) {
        while (!enemy.isDefeated()) {   //적이 쓰러질 때까지 반복

            boolean attacked = false;
            long startTime = System.currentTimeMillis();

            // 3초간 조건 만족하는 변수 탐색
            while (System.currentTimeMillis() - startTime < ATTACK_TIMEOUT) {
                if (enemy.isDefeated()) return;

                int attackAttempt = random.nextInt(100);
                if (attackAttempt < ATTACK_PROBABILITY_THRESHOLD) {       // 조건 만족 → 즉시 공격
                    attack(attacker, enemy, isPlayer);
                    attacked = true;
                    break;
                }

                SleepUtill.sleep(INTERVAL);
            }

            // 3초 내 조건 미충족 → 공격 시도
            if (!attacked && !enemy.isDefeated()) {
                attack(attacker, enemy, isPlayer);
            }
        }
    }

    //단일 공격
    private static void attack(Pokemon attacker, Enemy enemy, boolean isPlayer) {
        int damage = calcDamage(attacker.getExp()); //데미지는 exp에 비례하여 증가
        SleepUtill.sleep(500); // 공격에 시간 소모

        boolean success = enemy.takeDamage(damage, isPlayer);
        if (success) {
            System.out.println(attacker.getName() + " 공격! 데미지: " + damage + " 적 남은 HP: " + enemy.getHp());
        }
    }
    private static int calcDamage(int exp) {
        int base = Math.max(5, exp / 5);   //최소 데미지는 5, 경험치가 쌓일수록 기본 대미지가 증가
        return base + random.nextInt(base + 1); //데미지는 기본 대미지에 랜덤하게 추가하여 결정
    }
}