package org.example;

import org.example.domain.Pichu;
import org.example.domain.Pokemon;
import org.example.utill.DrawHandler;
import org.example.utill.EndingHandler;
import org.example.utill.EvolutionHandler;
import org.example.utill.SleepUtill;

import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("========================");
        DrawHandler.drawPokemonLogo();
        System.out.println("포켓몬 키우기 게임을 시작합니다");
        System.out.println("========================");
        System.out.print("피츄의 이름을 입력하세요 : ");
        String name = sc.nextLine();

        int days;

        while (true) {

            System.out.print("함께 지낼 일 수를 입력하세요 (3~15) : ");
            days = sc.nextInt();

            if (days >= 3 && days <= 15) {
                break;
            }

            System.out.println("3~15 사이의 숫자를 입력해주세요.");
        }

        Pokemon pokemon = new Pichu(name);

        for (int day = 1; day <= days; day++) {

            System.out.println("========================");
            System.out.println(day + "일차");
            System.out.println("========================");

            pokemon.printStatus();

            System.out.println("행동을 선택하세요.");
            System.out.println("1. 밥 먹기");
            System.out.println("2. 산책하기");
            System.out.println("3. 사냥하기");
            System.out.println("4. 스킬 사용해보기");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    pokemon.eat();
                    break;
                case 2:
                    pokemon.walk();
                    break;
                case 3:
                    pokemon.hunt();
                    break;
                case 4:
                    pokemon.useSkill();
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }

            pokemon = EvolutionHandler.evolveIfPossible(pokemon);

            System.out.println("행동 후 상태");
            pokemon.printStatus();
        }


        pokemon.printStatus();

        EndingHandler.printEnding(pokemon);
        SleepUtill.sleep(1000);

        System.out.println("========================");
        System.out.println("게임이 종료되었습니다.");
        System.out.println("========================");



        sc.close();
    }
}