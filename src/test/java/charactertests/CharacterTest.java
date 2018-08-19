package charactertests;

import models.character.LevelType;
import models.creatures.Pet;
import models.enemyclasses.Goblin;
import models.interfaces.IItem;
import models.items.Potion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import models.character.Character;
import models.playerclasses.Barbarian;
import models.playerraces.Human;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class CharacterTest {

	Character character;
	Human human;
	Barbarian barbarian;
	Goblin goblin;
	Goblin goblin2;
	Goblin goblin3;
	Goblin goblin4;
	Goblin goblin5;
	Potion potion;

	@Before
	public void before() {
		human = new Human();
		barbarian = new Barbarian();
		character = new Character("Vicky", human, barbarian);
		goblin = new Goblin();
		goblin2 = new Goblin();
		goblin3 = new Goblin();
		goblin4 = new Goblin();
		goblin5 = new Goblin();
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

//	@Test
//	public void canGetPlayerClass() {
//		assertEquals(barbarian, character.getPlayerClass());
//	}

	@Test
	public void canGetPlayerRace() {
		assertEquals(human, character.getPlayerRace());
	}

	@Test
	public void canGetLevel(){
		assertEquals(LevelType.LEVEL_01, character.getLevel());
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
		assertEquals(80, goblin.getHealthPoints());
	}

	@Test
	public void canReturnEnemyDamageTaken(){
		assertEquals("You hit the enemy and reduced its health by 20 points!", character.attackEnemy(goblin));
	}

	@Test
	public void canKillTheEnemyAndGainPoints(){
		character.attackEnemy(goblin);
		character.attackEnemy(goblin);
		character.attackEnemy(goblin);
		character.attackEnemy(goblin);
		assertEquals(20, goblin.getHealthPoints());
		assertEquals("You killed the enemy!", character.attackEnemy(goblin));
		assertEquals(0, goblin.getHealthPoints());
		assertEquals(true, goblin.isDead());
		assertEquals(25, character.getExperiencePoints());
	}

	@Test
	public void canLevelUp(){
		assertEquals(LevelType.LEVEL_01, character.getLevel());
		character.attackEnemy(goblin);
		character.attackEnemy(goblin);
		character.attackEnemy(goblin);
		character.attackEnemy(goblin);
		character.attackEnemy(goblin);
		assertTrue (goblin.isDead());
		assertEquals(25, character.getExperiencePoints());
		character.attackEnemy(goblin2);
		character.attackEnemy(goblin2);
		character.attackEnemy(goblin2);
		character.attackEnemy(goblin2);
		character.attackEnemy(goblin2);
		assertTrue (goblin.isDead());
		assertEquals(50, character.getExperiencePoints());
		character.attackEnemy(goblin3);
		character.attackEnemy(goblin3);
		character.attackEnemy(goblin3);
		character.attackEnemy(goblin3);
		character.attackEnemy(goblin3);
		assertTrue (goblin.isDead());
		assertEquals(75, character.getExperiencePoints());
		character.attackEnemy(goblin4);
		character.attackEnemy(goblin4);
		character.attackEnemy(goblin4);
		character.attackEnemy(goblin4);
		character.attackEnemy(goblin4);
		assertTrue (goblin.isDead());
		assertEquals(100, character.getExperiencePoints());
		assertEquals(LevelType.LEVEL_02, character.getLevel());
	}

	@Test
	public void canAddTitles(){
		assertEquals("Vicky the Human Barbarian", character.getNameWithTitles());
	}

	@Test
	public void canPickUpItemAndAddToInventory(){
		boolean pickedUp = character.pickUpItem(potion);
		assertEquals(1, character.getNumberOfInventoryItems());
		assertTrue(pickedUp);
	}

	@Test
	public void cannotPickUpItem(){
		boolean pickedUp = true;

		// Try to pick up 11 items to add to default inventory of size 10
		for (int i = 0; i < 11; i++){
			pickedUp = character.pickUpItem(new Potion());
		}

		// Check we only have 10
		Assert.assertEquals(10, character.getNumberOfInventoryItems());
		assertFalse(pickedUp);
	}

	// same as above with less logic
	@Test
	public void cantPickUpItemIfInventoryIsFull(){
		// add 9 potions to the inventory
		character.pickUpItem(new Potion());
		character.pickUpItem(new Potion());
		character.pickUpItem(new Potion());
		character.pickUpItem(new Potion());
		character.pickUpItem(new Potion());
		character.pickUpItem(new Potion());
		character.pickUpItem(new Potion());
		character.pickUpItem(new Potion());
		character.pickUpItem(new Potion());

		// add a tenth potion and check it that it returns pickedup = true
		// check that there are now 10 items in the inventory
		assertTrue(character.pickUpItem(new Potion()));
		assertEquals(10, character.getNumberOfInventoryItems());

		// add an eleventh potion and check that it returns pickedup = false
		// check that there are still only 10 items in the inventory
		assertFalse (character.pickUpItem(new Potion()));
		assertEquals(10, character.getNumberOfInventoryItems());
	}

	@Test
	public void canGetAllInventoryItems(){
		character.pickUpItem(potion);
		ArrayList<IItem> items = character.getAllItems();
		assertEquals(1, items.size());
	}

	@Test
	public void canDropInventoryItem(){
		character.pickUpItem(potion);
		boolean dropped = character.dropInventoryItem(potion);
		ArrayList<IItem> items = character.getAllItems();
		assertFalse(items.contains(potion));
		assertTrue(dropped);
	}

	@Test
	public void cannotDropItem(){
		boolean dropped = character.dropInventoryItem(potion);
		assertFalse(dropped);
	}

	@Test
	public void consumePotion(){
		character.pickUpItem(potion);
		character.consumeHealthItemFromInventory(potion);
		assertEquals(110, character.getHealthPoints());
		ArrayList<IItem> items = character.getAllItems();
		assertFalse(items.contains(potion));
	}

}
