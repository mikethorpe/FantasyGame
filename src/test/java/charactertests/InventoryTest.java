package charactertests;
import interfaces.IItem;
import itemstests.Potion;
import itemstests.Sword;
import org.junit.Before;
import org.junit.Test;
import character.Inventory;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InventoryTest {

	Inventory inventory;
	Potion potion;
	IItem sword;

	@Before
	public void before(){
		inventory = new Inventory();
		potion = new Potion();
		sword = new Sword();
	}

	@Test
	public void inventoryStartsWithNoItems(){
		assertEquals(0, inventory.getNumberOfItems());
	}

	@Test
	public void canAddItemToInventory(){
		inventory.addItem(potion);
		assertEquals(1, inventory.getNumberOfItems());
	}

	@Test
	public void canGetAllItems(){
		boolean addedItem = inventory.addItem(potion);
		ArrayList<IItem> items = inventory.getAllItems();
		assertEquals(1, items.size());
		assertTrue(addedItem);
	}

	@Test
	public void canRemoveSpecificItem(){
		inventory.addItem(potion);
		inventory.addItem(sword);
		inventory.removeItem(potion);
		ArrayList<IItem> items = inventory.getAllItems();
		assertFalse(items.contains(potion));
	}


	@Test
	public void cannotAddMoreThan10ItemsToDefaultInventory(){

		boolean addedItem = true;

		// Try to add 11 items to default inventory
		for (int i = 0; i < 11; i++){
			addedItem = inventory.addItem(new Potion());
		}

		// Check we only have 10
		assertEquals(10, inventory.getNumberOfItems());
		assertFalse(addedItem);
	}
}
