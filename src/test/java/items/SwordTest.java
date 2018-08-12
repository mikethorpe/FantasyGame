package items;

import interfaces.IWeapon;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SwordTest {

	IWeapon weapon;

	@Before
	public void before(){
		weapon = new Sword();
	}

	@Test
	public void canGetAttackPoints(){
		assertEquals(5, weapon.getAttackPoints());
	}
}
