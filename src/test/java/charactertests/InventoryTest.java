package charactertests;
import interfaces.IItem;
import itemstests.Potion;
import itemstests.Sword;
import org.junit.Before;
import org.junit.Test;
import character.Inventory;

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
	public void cannotAddMoreItemsThanInventorySize(){

		// Create inventory with size 11
		Inventory inventory = new Inventory(11);

		boolean addedItem = true;

		// Try to add 12 items to inventory
		for (int i = 0; i < 12; i++){
			addedItem = inventory.addItem(new Potion());
		}

		// Check we only have 11 items in the inventory
		assertEquals(11, inventory.getNumberOfItems());
		assertFalse(addedItem);
	}

	@Test
	public void defaultInventoryIsOfSizeTen(){
		assertEquals(10, inventory.getInventorySize());
	}


	@Test
	public void canInstatiateInventoryOfDifferentSize(){
		Inventory inventory = new Inventory(11);
		assertEquals(11, inventory.getInventorySize());
	}
}
