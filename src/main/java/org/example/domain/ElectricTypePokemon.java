package org.example.domain;

public abstract class ElectricTypePokemon extends Pokemon {

    boolean isElectricResistant = true;     //현재는 필요없는 필드이지만 2차 상속 추가 경험과 추후 타입 속성 확장 시 상성을 위해 존재합니다.

    public ElectricTypePokemon(String name) {
        super(name);
    }

    public ElectricTypePokemon(String name, int exp, int affection) {
        super(name, exp, affection);
    }
}
