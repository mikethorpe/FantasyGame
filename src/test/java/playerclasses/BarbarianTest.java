package playerclasses;

import enemyclasses.Goblin;
import itemsTests.Weapon;
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

	@Test
	public void canAddWeapon(){
		barbarian.addWeapon(weapon);
		assertEquals(weapon, barbarian.getWeapon());
	}

	@Test
	public void canAttackEnemy(){
		barbarian.addWeapon(weapon);
		barbarian.attackEnemy(goblin);
		assertEquals(95, goblin.getHealthPoints());
	}

	@Test
	public void canReturnEnemyDamageTaken(){
		barbarian.addWeapon(weapon);
		assertEquals("Ouch, that hurt by exactly 5 points!", barbarian.attackEnemy(goblin));
	}

}
