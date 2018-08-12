package items;

import interfaces.IItem;
import interfaces.IWeapon;

public class Sword implements IWeapon, IItem {

	private int attackPoints;

	public Sword() {
		this.attackPoints = 5;
	}

	public int getAttackPoints() {
		return attackPoints;
	}
}
