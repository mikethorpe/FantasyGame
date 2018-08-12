package playertests;
import org.junit.Test;
import player.Inventory;

import static org.junit.Assert.assertEquals;

public class InventoryTests {

	@Test
	public void inventoryStartsWithNoItems(){
		Inventory inventory = new Inventory();
		assertEquals(0, inventory.getNumberOfItems());
	}

}
