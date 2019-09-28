package com.unit2;

import com.unit2.damage.Damage;
import com.unit2.damage.DamageType;
import com.unit2.weapons.Weapon;
import com.unit2.weapons.WeaponClass;

public class TargetRange {
    public static void main(String[] args) {
        TargetRange tr = new TargetRange();
        Weapon theBow = tr.createBowOfFireButt();
        Weapon theSword = tr.createSwordOfFreezingArse();

        System.out.println("Weapons equipped, ready to mingle");
    }

    public Weapon createBowOfFireButt() {
        Weapon bow = new Weapon();
        bow.name = "Bow of FireButt";
        bow.weaponClass = WeaponClass.Ranged;

        Damage damage1 = new Damage(DamageType.Fire, 100500);
        Damage damage2 = new Damage(DamageType.Earth, 9001);
        bow.damageTypes = new Damage[]{damage1, damage2};

        return bow;
    }

    public Weapon createSwordOfFreezingArse() {
        Weapon sword = new Weapon();
        sword.name = "Sword of FreezingArse";
        sword.weaponClass = WeaponClass.Melee;

        Damage damage1 = new Damage(DamageType.Freeze, 100);
        Damage damage2 = new Damage(DamageType.Shock, 150);
        sword.damageTypes = new Damage[]{damage1, damage2};

        return sword;
    }
}
