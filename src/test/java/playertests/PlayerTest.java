package playertests;

import creatures.Pet;
import enemyclasses.Goblin;
import items.Potion;
import org.junit.Before;
import org.junit.Test;
import player.Player;
import playerclasses.Barbarian;
import playerraces.Human;

import static junit.framework.TestCase.assertEquals;

public class PlayerTest {


	Player player;
	Human human;
	Barbarian barbarian;
	Goblin goblin;

	@Before
	public void before() {
		human = new Human();
		barbarian = new Barbarian();
		player = new Player("Vicky", human, barbarian);
		goblin = new Goblin();
	}

	@Test
	public void canGetName() {
		assertEquals("Vicky", player.getName());
	}

	@Test
	public void canGetHealthPoints() {
		assertEquals(100, player.getHealthPoints());
	}

	@Test
	public void canGetPlayerClass() {
		assertEquals(barbarian, player.getPlayerClass());
	}

	@Test
	public void canGetPlayerRace() {
		assertEquals(human, player.getPlayerRace());
	}

	@Test
	public void canAddPotion() {
		Potion potion = new Potion();
		player.addPotion(potion);
		assertEquals(potion, player.getPotion());
	}

	@Test
	public void canAddPet(){
		Pet pet = new Pet();
		player.addPet(pet);
		assertEquals(pet, player.getPet());
	}

	@Test
	public void hasWeapon(){
		assertEquals(barbarian.getWeapon(), player.getWeapon());
	}

	@Test
	public void canAttackEnemy(){
		player.attackEnemy(goblin);
		assertEquals(95, goblin.getHealthPoints());
	}

	@Test
	public void canReturnEnemyDamageTaken(){
		assertEquals("Ouch, that hurt by exactly 5 points!", player.attackEnemy(goblin));
	}

	@Test
	public void canAddTitles(){
		assertEquals("Vicky the Human Barbarian", player.getNameWithTitles());
	}
}
