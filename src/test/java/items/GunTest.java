package items;

import interfaces.IWeapon;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GunTest {

    IWeapon weapon;

    @Before
    public void before(){
        weapon = new Gun();
    }

    @Test
    public void canGetAttackPoints(){
        assertEquals(6, weapon.getAttackPoints());
    }
}
