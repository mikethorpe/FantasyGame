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

	public void addItem(IItem item){
		inventoryItems.add(item);
	}

	public ArrayList<IItem> getAllItems(){
		return this.inventoryItems;
	}

	public boolean removeItem(IItem item){
		return inventoryItems.remove(item);
	}
}
