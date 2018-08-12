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
		inventory.addItem(potion);
		ArrayList<IItem> items = inventory.getAllItems();
		assertEquals(1, items.size());
	}

	@Test
	public void canRemoveSpecificItem(){
		inventory.addItem(potion);
		inventory.addItem(sword);
		inventory.removeItem(potion);
		ArrayList<IItem> items = inventory.getAllItems();
		assertFalse(items.contains(potion));
	}
}
