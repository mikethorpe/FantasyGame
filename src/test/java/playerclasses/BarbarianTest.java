package playerclasses;

import enemyclasses.Goblin;
import items.Weapon;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BarbarianTest {

	Barbarian barbarian;
	Goblin goblin;
	Weapon weapon;

	@Before
	public void before(){
		barbarian = new Barbarian();
		goblin = new Goblin();
		weapon = new Weapon();
	}

	@Test
	public void canGetTitle(){
		assertEquals("Barbarian", barbarian.getTitle());
	}

}
