package com.unit2;

import com.unit2.targets.Target;
import com.unit2.weapons.Weapon;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeaponsTest {
    @Test
    public void testBow() {
        TargetRange tr = new TargetRange();
        Weapon theBow = tr.createBowOfFireButt();
        Weapon theSword = tr.createSwordOfFreezingArse();

        Target t1 = new Target(100);
        t1.freezeResist = 100;
        t1.shockResist = 100;
        t1.fireResist = 100;
        t1.earthResist = 100;

        t1.takeHit(theBow);

        assertFalse("target must be still alive, its immune", t1.getIsDestroyed());
    }
}
