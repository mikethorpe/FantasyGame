package items;

import interfaces.IItem;
import interfaces.IWeapon;

public class Sword implements IWeapon, IItem {

	private String name;
	private int attackPoints;

	public Sword() {
		this.attackPoints = 20;
		this.name = "Sword";
	}

	public int getAttackPoints() {
		return attackPoints;
	}

	@Override
	public String getName(){
		return this.name;
	}
}
