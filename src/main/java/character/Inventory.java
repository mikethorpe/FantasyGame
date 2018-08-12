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

	public boolean addItem(IItem item){
		if (inventoryItems.size() < 10) {
			return inventoryItems.add(item);
		}
		return false;
	}

	public ArrayList<IItem> getAllItems(){
		return this.inventoryItems;
	}

	public boolean removeItem(IItem item){
		return inventoryItems.remove(item);
	}
}
