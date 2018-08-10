package playerclassestests;

import creatures.Pet;
import interfaces.IPlayerType;

public class Warlock implements IPlayerType {

	private Pet pet;
	private String title;

	public Warlock() {
		this.title = "Warlock";
	}

	@Override
	public String getTitle(){
		return this.title;
	}

}
