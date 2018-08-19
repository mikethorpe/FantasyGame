package playerclassestests;

import models.enemyclasses.Goblin;
import models.items.Sword;
import org.junit.Before;
import org.junit.Test;
import models.playerclasses.Barbarian;

import static junit.framework.TestCase.assertEquals;

public class BarbarianTest {

	Barbarian barbarian;
	Goblin goblin;

	@Before
	public void before(){
		barbarian = new Barbarian();
		goblin = new Goblin();
	}

	@Test
	public void canGetTitle(){
		assertEquals("Barbarian", barbarian.getClassTitle());
	}

	@Test
	public void defaultWeaponIsSword(){
		assertEquals( Sword.class, barbarian.getWeapon().getClass());
	}

}
