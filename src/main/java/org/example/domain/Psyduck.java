package org.example.domain;

import org.example.skills.Tackelable;
import org.example.skills.WaterGunnable;
import org.example.utill.DrawHandler;
import org.example.utill.SleepUtill;

public class Psyduck extends WaterTypePokemon implements Tackelable, WaterGunnable {
    public Psyduck(String name) {
        super(name);
    }

    public Psyduck(String name, int exp, int affection) {
        super(name, exp, affection);
    }

    @Override
    public void useSkill() {
        useTackle();
        useWaterGun();
    }

    @Override
    public void drawPokemon() {
        DrawHandler.drawPsyduck();
    }

    @Override
    public void useTackle() {
        System.out.println(name + "의 몸통박치기!");
        SleepUtill.sleep(1000);
    }

    @Override
    public void useWaterGun() {
        System.out.println(name + "의 물대포!");
        SleepUtill.sleep(1000);
    }
}
