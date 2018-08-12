package playerclasses;

import items.Gun;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class HunterTest {

	Hunter hunter;

	@Before
	public void before(){
		hunter = new Hunter();
	}

	@Test
	public void canGetTitle(){
		assertEquals("Hunter", hunter.getClassTitle());
	}

	@Test
	public void defaultWeaponIsGun(){
		assertEquals( Gun.class, hunter.getWeapon().getClass());
	}
}