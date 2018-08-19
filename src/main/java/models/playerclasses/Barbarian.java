package models.playerclasses;

import models.interfaces.IPlayerClass;
import models.interfaces.IWeapon;
import models.items.Sword;

public class Barbarian implements IPlayerClass {

	private String classTitle;
	private IWeapon weapon;

	public Barbarian(){
		this.weapon = new Sword();
		this.classTitle = "Barbarian";
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
