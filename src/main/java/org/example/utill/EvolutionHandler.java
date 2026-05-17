package org.example.utill;

import org.example.domain.Picachu;
import org.example.domain.Pichu;
import org.example.domain.Pokemon;
import org.example.domain.Raichu;

public class EvolutionHandler {
    public static Pokemon evolveIfPossible(Pokemon pokemon) {

        if (pokemon instanceof Pichu && pokemon.getExp() >= 100) {

            System.out.println("피츄가 피카츄로 진화했습니다!");
            System.out.println("이제 백만볼트를 사용할 수 있습니다!");
            SleepUtill.sleep(2000);
            return new Picachu(
                    pokemon.getName(),
                    pokemon.getExp(),
                    pokemon.getAffection()
            );
        }

        if (pokemon instanceof Picachu && pokemon.getExp() >= 250) {

            System.out.println("피카츄가 라이츄로 진화했습니다!");
            System.out.println("이제 볼트태클을 사용할 수 있습니다!");
            SleepUtill.sleep(2000);
            return new Raichu(
                    pokemon.getName(),
                    pokemon.getExp(),
                    pokemon.getAffection()
            );
        }

        return pokemon;
    }
}
