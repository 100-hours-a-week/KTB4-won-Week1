package org.example.domain;

import org.example.skills.Tackelable;
import org.example.utill.DrawHandler;
import org.example.utill.SleepUtill;

public class Pichu extends ElectricTypePokemon implements Tackelable {

    public Pichu(String name) {
        super(name);
    }

    @Override
    public void useTackle() {
        System.out.println(name + "의 몸통박치기!");
        SleepUtill.sleep(1000);
    }

    @Override
    public void useSkill() {
        useTackle();
    }

    @Override
    public void drawPokemon() {
        DrawHandler.drawPichu();
    }
}
