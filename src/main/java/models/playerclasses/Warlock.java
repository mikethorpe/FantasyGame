package models.playerclasses;

import models.creatures.Pet;
import models.interfaces.IPlayerClass;
import models.interfaces.IWeapon;
import models.items.Staff;

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
