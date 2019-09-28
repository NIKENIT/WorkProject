package com.unit2.targets;

import com.unit2.damage.Damage;
import com.unit2.damage.DamageType;
import com.unit2.weapons.Weapon;

public class Target {
    public Number fireResist = 0;
    public Number freezeResist = 0;
    public Number earthResist = 0;
    public Number shockResist = 0;
    private Number health;
    private Number remainingHealth;
    private boolean isDestroyed = false;

    public Number getRemainingHealth() {
        return this.remainingHealth;
    }

    public Number getTotalHealth() {
        return this.health;
    }

    public Target(Number health) {
        this.health = health;
        this.remainingHealth = health;
    }

    public void takeHit(Weapon weapon) {
        if (weapon.damageTypes.length > 0) {
            for (int i = 0; i < weapon.damageTypes.length; i++) {
                this.takeDamage(weapon.damageTypes[i]);
            }
        }
    }

    public void takeDamage(Damage damage) {
        Number initialDamage = damage.number;
        switch (damage.type) {
            case Earth:
                initialDamage = initialDamage.doubleValue() - initialDamage.doubleValue() * this.earthResist.doubleValue();
                break;
            case Fire:
                initialDamage = initialDamage.doubleValue() - initialDamage.doubleValue() * this.fireResist.doubleValue();
                break;
            case Shock:
                initialDamage = initialDamage.doubleValue() - initialDamage.doubleValue() * this.shockResist.doubleValue();
                break;
            case Freeze:
                initialDamage = initialDamage.doubleValue() - initialDamage.doubleValue() * this.freezeResist.doubleValue();
                break;
        }

        this.remainingHealth = this.remainingHealth.doubleValue() - initialDamage.doubleValue();
        if (this.remainingHealth.intValue() <= 0) {
            this.isDestroyed = true;
        }
    }

    public boolean getIsDestroyed() {
        return this.isDestroyed;
    }
}
