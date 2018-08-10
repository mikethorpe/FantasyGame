package playerclasses;

import interfaces.IPlayerType;
import items.Weapon;

public class Cleric implements IPlayerType {

	private String title;
	private Weapon weapon;

	public Cleric() {
		this.title = "Cleric";
		this.weapon = new Weapon();
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public Weapon getWeapon(){
		return this.weapon;
	}
}
