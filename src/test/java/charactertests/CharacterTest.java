package charactertests;

import character.LevelType;
import creatures.Pet;
import enemyclasses.Goblin;
import interfaces.IItem;
import itemstests.Potion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import character.Character;
import playerclasses.Barbarian;
import playerraces.Human;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

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

}
