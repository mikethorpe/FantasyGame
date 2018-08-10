package playerclasses;

import creatures.Pet;
import interfaces.IPlayerType;
import items.Weapon;

public class Warlock implements IPlayerType {

	private Pet pet;
	private String title;
	private Weapon weapon;

	public Warlock() {
		this.title = "Warlock";
		this.weapon = new Weapon();
	}

	@Override
	public String getTitle(){
		return this.title;
	}

	@Override
	public Weapon getWeapon(){
		return this.weapon;
	}

}
