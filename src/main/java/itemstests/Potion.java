package itemstests;

import interfaces.IItem;

public class Potion implements IItem {

	private String name;

	public Potion() {
		this.name = "Potion";
	}

	@Override
	public String getName() {
		return this.name;
	}
}
