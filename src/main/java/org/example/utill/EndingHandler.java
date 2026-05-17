package org.example.utill;

import org.example.domain.Pokemon;

public class EndingHandler {
    public static void printEnding(Pokemon pokemon) {

        System.out.println("\n===== 엔딩 =====");

        if (pokemon.getAffection() <= 50) {

            System.out.println(
                    "[배드엔딩]" + pokemon.getName()+ "(은)는 외로움을 느끼고 떠나버렸다..."
            );

            return;
        }

        if (pokemon.getExp() - pokemon.getAffection() >= 100) {

            System.out.println(
                    "[배드엔딩]" + pokemon.getName()+ "(은)는 더 강해지기 위해 여행을 떠났다..."
            );

            return;
        }

        System.out.println(
                "[해피엔딩]" + pokemon.getName()+ "(은)는 앞으로도 쭉 당신과 함께하기로 했다!"
        );
    }
}
