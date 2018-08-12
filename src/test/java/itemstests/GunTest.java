package itemstests;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GunTest {

    Gun gun;

    @Before
    public void before(){
        gun = new Gun();
    }

    @Test
    public void canGetAttackPoints(){
        assertEquals(6, gun.getAttackPoints());
    }

    @Test
    public void canGetName(){
        assertEquals("Gun", gun.getName());
    }
}
