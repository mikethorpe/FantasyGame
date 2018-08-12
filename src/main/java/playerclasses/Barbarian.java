package playerclasses;

import interfaces.IPlayerType;
import interfaces.IWeapon;
import items.Sword;

public class Barbarian implements IPlayerType {

	private String title;
	private IWeapon weapon;

	public Barbarian(){
		this.weapon = new Sword();
		this.title = "Barbarian";
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
