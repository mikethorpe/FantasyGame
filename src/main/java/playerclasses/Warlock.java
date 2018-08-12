package playerclasses;

import creatures.Pet;
import interfaces.IPlayerType;
import interfaces.IWeapon;
import items.Staff;

public class Warlock implements IPlayerType {

	private Pet pet;
	private String title;
	private IWeapon weapon;

	public Warlock() {
		this.title = "Warlock";
		this.weapon = new Staff();
	}

	@Override
	public String getTitle(){
		return this.title;
	}

	@Override
	public IWeapon getWeapon(){
		return this.weapon;
	}

}
