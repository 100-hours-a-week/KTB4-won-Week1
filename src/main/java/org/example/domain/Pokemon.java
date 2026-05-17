package org.example.domain;

import org.example.utill.SleepUtill;

import java.util.Random;

public abstract class Pokemon {

    protected String name;
    protected int exp;
    protected int affection;
    protected int level;

    protected Random random = new Random();

    public Pokemon(String name) {
        this.name = name;
        this.exp = 0;
        this.affection = 0;
        this.level = 1;
    }

    public Pokemon(String name, int exp, int affection) {
        this.name = name;
        this.exp = exp;
        this.affection = affection;
        updateLevel();
    }

    public void eat() {

        System.out.println(name + "(이)가 맛있게 밥을 먹었다!");
        System.out.println("애정도와 경험치가 10씩 증가합니다!");
        exp += 10;
        affection += 10;

        updateLevel();
        SleepUtill.sleep(1000);
    }

    public void walk() {

        System.out.println(name + "(와)과 산책을 했다!");
        System.out.println("애정도와 경험치가 20씩 증가합니다!");
        exp += 20;
        affection += 20;

        updateLevel();
        SleepUtill.sleep(1000);

    }

    public void hunt() {

        int successRate = 40 + ((exp / 10) * 5);
        int chance = random.nextInt(100);

        if (chance < successRate) {

            System.out.println(name + "의 사냥 성공!");
            System.out.println("애정도와 경험치가 50씩 증가합니다!");
            exp += 50;
            affection += 50;
            SleepUtill.sleep(1000);

        }
        else {

            System.out.println(name + "의 사냥 실패...");
            System.out.println("애정도가 30 하락했습니다.");
            affection -= 30;

            if (affection < 0) {
                affection = 0;
            }
            SleepUtill.sleep(1000);
        }

        updateLevel();
    }

    public void updateLevel() {
        this.level = (exp / 50) + 1;
    }

    public void printStatus() {
        drawPokemon();
        System.out.println("이름 : " + name);
        System.out.println("레벨 : " + level);
        System.out.println("경험치 : " + exp);
        System.out.println("애정도 : " + affection);
    }

    public abstract void useSkill();
    public abstract void drawPokemon();

    public String getName() {
        return name;
    }

    public int getExp() {
        return exp;
    }

    public int getAffection() {
        return affection;
    }
}