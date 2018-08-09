package itemsTests;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class WeaponTest {

	Weapon weapon;
	@Before
	public void before(){
		weapon = new Weapon();
	}

	@Test
	public void canGetAttackPoints(){
		assertEquals(5, weapon.getAttackPoints());
	}
}
