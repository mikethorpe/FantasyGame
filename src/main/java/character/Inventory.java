package character;

import interfaces.IItem;
import java.util.ArrayList;

public class Inventory {

	private ArrayList<IItem> inventoryItems;

	public Inventory() {
		this.inventoryItems = new ArrayList<>();
	}

	public int getNumberOfItems(){
		return this.inventoryItems.size();
	}

}
