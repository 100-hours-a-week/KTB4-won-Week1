package org.example.domain;

public abstract class ElectricTypePokemon extends Pokemon {

    boolean isElectricResistant = true;

    public ElectricTypePokemon(String name) {
        super(name);
    }

    public ElectricTypePokemon(String name, int exp, int affection) {
        super(name, exp, affection);
    }
}
