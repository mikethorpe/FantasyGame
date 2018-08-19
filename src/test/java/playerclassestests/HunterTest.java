package playerclassestests;

import models.items.Gun;
import org.junit.Before;
import org.junit.Test;
import models.playerclasses.Hunter;

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