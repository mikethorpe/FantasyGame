package items;

import interfaces.IHealthConsumable;
import interfaces.IItem;

public class Potion implements IItem, IHealthConsumable {

	private String name;
	private int healthPoints;

	public Potion() {
		this.name = "Potion";
		this.healthPoints = 10;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int giveHealthPoints(){
		return healthPoints;
	}
}
