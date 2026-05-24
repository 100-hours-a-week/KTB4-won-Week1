package org.example.domain;

public abstract class WaterTypePokemon extends Pokemon {
    boolean isWaterResistant = true;
    // 추후 타입 상성 확장 시 활용

    public WaterTypePokemon(String name) {
        super(name);
    }

    public WaterTypePokemon(String name, int exp, int affection) {
        super(name, exp, affection);
    }
}
