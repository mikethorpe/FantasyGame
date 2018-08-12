package playerclasses;

import interfaces.IPlayerType;
import interfaces.IWeapon;
import items.Gun;

public class Hunter implements IPlayerType {

	private String title;
	private IWeapon weapon;

	public Hunter() {
		this.title = "Hunter";
		this.weapon = new Gun();
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public IWeapon getWeapon(){
		return this.weapon;
	}
}
