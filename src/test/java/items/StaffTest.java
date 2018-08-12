package items;

import interfaces.IWeapon;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class StaffTest {

    IWeapon weapon;

    @Before
    public void before(){
        weapon = new Staff();
    }

    @Test
    public void canGetAttackPoints(){
        assertEquals(4, weapon.getAttackPoints());
    }
}