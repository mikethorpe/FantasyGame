package playerclasses;

import enemyclasses.Goblin;
import items.Sword;
import org.junit.Before;
import org.junit.Test;

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
		assertEquals("Barbarian", barbarian.getTitle());
	}

	@Test
	public void defaultWeaponIsSword(){
		assertEquals( Sword.class, barbarian.getWeapon().getClass());
	}

}
