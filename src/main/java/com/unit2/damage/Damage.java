package com.unit2.damage;

public class Damage {
    public Number number;
    public DamageType type;

    public Damage(DamageType damageType, Number damageNumber) {
        this.type = damageType;
        this.number = damageNumber;
    }

    public Damage() {};
}
