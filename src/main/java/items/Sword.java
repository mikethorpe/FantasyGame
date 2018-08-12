package items;

import interfaces.IWeapon;

public class Sword implements IWeapon {

	private int attackPoints;

	public Sword() {
		this.attackPoints = 5;
	}

	public int getAttackPoints() {
		return attackPoints;
	}
}
