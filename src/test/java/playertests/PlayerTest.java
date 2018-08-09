package playertests;

import creatures.Pet;
import enemyclasses.Goblin;
import itemsTests.Potion;
import itemsTests.Weapon;
import org.junit.Before;
import org.junit.Test;
import player.Player;
import playerclassestests.Barbarian;

import static junit.framework.TestCase.assertEquals;

public class PlayerTest {


	Player player;
	Barbarian barbarian;
	Goblin goblin;
	Weapon weapon;

	@Before
	public void before() {
		barbarian = new Barbarian();
		player = new Player("Vicky", barbarian);
		goblin = new Goblin();
		weapon = new Weapon();
	}

	@Test
	public void canGetNameAndTitle() {
		assertEquals("Vicky", player.getName());
	}

	@Test
	public void canGetHealthPoints() {
		assertEquals(100, player.getHealthPoints());
	}

	@Test
	public void canGetPlayerType() {
		assertEquals(barbarian, player.getPlayerType());
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
	public void canAddWeapon(){
		player.addWeapon(weapon);
		assertEquals(weapon, player.getWeapon());
	}

	@Test
	public void canAttackEnemy(){
		player.addWeapon(weapon);
		player.attackEnemy(goblin);
		assertEquals(95, goblin.getHealthPoints());
	}

	@Test
	public void canReturnEnemyDamageTaken(){
		player.addWeapon(weapon);
		assertEquals("Ouch, that hurt by exactly 5 points!", player.attackEnemy(goblin));
	}

}
