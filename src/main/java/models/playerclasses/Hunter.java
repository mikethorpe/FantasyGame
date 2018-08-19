package models.playerclasses;

import models.interfaces.IPlayerClass;
import models.interfaces.IWeapon;
import models.items.Gun;

public class Hunter implements IPlayerClass {

	private String classTitle;
	private IWeapon weapon;

	public Hunter() {
		this.classTitle = "Hunter";
		this.weapon = new Gun();
	}

	@Override
	public String getClassTitle() {
		return classTitle;
	}

	@Override
	public IWeapon getWeapon(){
		return this.weapon;
	}
}
