package models.character;

import models.interfaces.IItem;
import java.util.ArrayList;

public class Inventory {

	private ArrayList<IItem> inventoryItems;
	private int inventorySize;

	public Inventory() {
		this.inventoryItems = new ArrayList<>();
		this.inventorySize = 10;
	}

	public Inventory(int inventorySize) {
		this.inventoryItems = new ArrayList<>();
		this.inventorySize = inventorySize;
	}

	public int getNumberOfItems(){
		return this.inventoryItems.size();
	}

	public boolean addItem(IItem item){
		if (inventoryItems.size() < inventorySize) {
			return inventoryItems.add(item);
		}
		return false;
	}

	public ArrayList<IItem> getAllItems(){
		return this.inventoryItems;
	}

	public boolean checkContainsItem(IItem item){
		return inventoryItems.contains(item);
	}

	public boolean removeItem(IItem item){
		return inventoryItems.remove(item);
	}

	public int getInventorySize(){
		return this.inventorySize;
	}
}
