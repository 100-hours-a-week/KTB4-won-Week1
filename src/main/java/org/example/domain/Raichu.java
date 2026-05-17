package org.example.domain;

import org.example.skills.BoltTackleable;
import org.example.skills.Millionboltable;
import org.example.skills.Tackelable;
import org.example.utill.DrawHandler;
import org.example.utill.SleepUtill;

public class Raichu extends ElectricTypePokemon implements Tackelable, Millionboltable, BoltTackleable {

    public Raichu(String name, int exp, int affection){
        super(name, exp, affection);
    }

    @Override
    public void useSkill() {
        useTackle();
        useMillionBolt();
        useBoltTackle();
    }

    @Override
    public void drawPokemon() {
        DrawHandler.drawRaichu();
    }

    @Override
    public void useBoltTackle() {
        System.out.println(name + "의 볼트태클!");
        SleepUtill.sleep(1000);
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
