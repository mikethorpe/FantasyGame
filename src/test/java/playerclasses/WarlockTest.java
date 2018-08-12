package playerclasses;

import items.Staff;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class WarlockTest {

	Warlock warlock;

	@Before
	public void before(){
		warlock = new Warlock();
	}

	@Test
	public void canGetTitle(){
		assertEquals("Warlock", warlock.getClassTitle());
	}

	@Test
	public void defaultWeaponIsStaff(){
		assertEquals( Staff.class, warlock.getWeapon().getClass());
	}

}
