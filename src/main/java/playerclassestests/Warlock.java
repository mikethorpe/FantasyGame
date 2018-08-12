package playerclassestests;

import creatures.Pet;
import interfaces.IPlayerClass;
import interfaces.IWeapon;
import itemstests.Staff;

public class Warlock implements IPlayerClass {

	private Pet pet;
	private String classTitle;
	private IWeapon weapon;

	public Warlock() {
		this.classTitle = "Warlock";
		this.weapon = new Staff();
	}

	@Override
	public String getClassTitle(){
		return this.classTitle;
	}

	@Override
	public IWeapon getWeapon(){
		return this.weapon;
	}

}
