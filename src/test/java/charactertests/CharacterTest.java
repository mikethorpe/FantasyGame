package charactertests;

import creatures.Pet;
import enemyclasses.Goblin;
import itemstests.Potion;
import org.junit.Before;
import org.junit.Test;
import character.Character;
import playerclasses.Barbarian;
import playerraces.Human;

import static junit.framework.TestCase.assertEquals;

public class CharacterTest {

	Character character;
	Human human;
	Barbarian barbarian;
	Goblin goblin;
	Potion potion;

	@Before
	public void before() {
		human = new Human();
		barbarian = new Barbarian();
		character = new Character("Vicky", human, barbarian);
		goblin = new Goblin();
		potion = new Potion();
	}

	@Test
	public void canGetName() {
		assertEquals("Vicky", character.getName());
	}

	@Test
	public void canGetHealthPoints() {
		assertEquals(100, character.getHealthPoints());
	}

	@Test
	public void canGetPlayerClass() {
		assertEquals(barbarian, character.getPlayerClass());
	}

	@Test
	public void canGetPlayerRace() {
		assertEquals(human, character.getPlayerRace());
	}

	@Test
	public void canAddPotion() {
		Potion potion = new Potion();
		character.addPotion(potion);
		assertEquals(potion, character.getPotion());
	}

	@Test
	public void canAddPet(){
		Pet pet = new Pet();
		character.addPet(pet);
		assertEquals(pet, character.getPet());
	}

	@Test
	public void hasWeapon(){
		assertEquals(barbarian.getWeapon(), character.getWeapon());
	}

	@Test
	public void canAttackEnemy(){
		character.attackEnemy(goblin);
		assertEquals(95, goblin.getHealthPoints());
	}

	@Test
	public void canReturnEnemyDamageTaken(){
		assertEquals("Ouch, that hurt by exactly 5 points!", character.attackEnemy(goblin));
	}

	@Test
	public void canAddTitles(){
		assertEquals("Vicky the Human Barbarian", character.getNameWithTitles());
	}

	@Test
	public void canPickUpItemAndAddToInventory(){
		character.pickUpItem(potion);
		assertEquals(1, character.getNumberOfInventoryItems());
	}

}
