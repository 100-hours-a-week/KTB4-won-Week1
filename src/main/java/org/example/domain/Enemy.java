package org.example.domain;

import java.util.concurrent.locks.ReentrantLock;

public class Enemy {

    private volatile int hp; //적의 체력, volatile 이용하여 메모리에서 최신 데이터 읽도록 선언.
    private boolean isPlayerWon = false;    //플레이어가 이겼는지 여부
    private final ReentrantLock lock = new ReentrantLock(); //연속으로 공격 가능하므로 ReentrantLock을 통한 동기화 구현

    public Enemy(int hp) {
        this.hp = hp;
    }

    // 공격 메서드. 성공 시 true, 이미 쓰러졌으면 false
    public boolean takeDamage(int damage, boolean isPlayer) {
        lock.lock();    //enemy에게 대미지 입히는 구간을 critical section으로 구현.
        try {
            if (hp <= 0) {
                return false; // 이미 죽은 상태
            }

            hp -= damage;

            if (hp <= 0) {
                hp = 0;
                isPlayerWon = isPlayer; //플레이어가 승리한 것인지
            }

            return true;

        } finally {
            lock.unlock();
        }
    }

    public boolean isDefeated() {   //적이 쓰러졌는지 확인, volatile이므로 락은 불필요
        return hp <= 0;

    }

    public int getHp() {
        return hp;
    }

    public boolean isPlayerWon() {
        return isPlayerWon;
    }
}
