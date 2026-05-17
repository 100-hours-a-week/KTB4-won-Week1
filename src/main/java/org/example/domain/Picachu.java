package org.example.domain;

import org.example.skills.Millionboltable;
import org.example.skills.Tackelable;
import org.example.utill.DrawHandler;
import org.example.utill.SleepUtill;

public class Picachu extends ElectricTypePokemon implements Tackelable, Millionboltable {

    public Picachu(String name, int affection, int exp) {
        super(name, affection, exp);
    }
    @Override
    public void useSkill() {
        useTackle();
        useMillionBolt();
    }

    @Override
    public void drawPokemon() {
        DrawHandler.drawPicachu();
    }

    @Override
    public void useMillionBolt() {
        System.out.println(name + "의 백만볼트!");
        SleepUtill.sleep(1000);

    }

    @Override
    public void useTackle() {
        System.out.println(name + "의 몸통박치기!");
        SleepUtill.sleep(1000);
    }
}
