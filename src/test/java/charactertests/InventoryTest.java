package charactertests;
import org.junit.Test;
import character.Inventory;

import static org.junit.Assert.assertEquals;

public class InventoryTest {

	@Test
	public void inventoryStartsWithNoItems(){
		Inventory inventory = new Inventory();
		assertEquals(0, inventory.getNumberOfItems());
	}

}
