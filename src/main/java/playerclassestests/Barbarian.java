package playerclassestests;

import interfaces.IPlayerType;

public class Barbarian implements IPlayerType {

	private String title;

	public Barbarian(){
		this.title = "Barbarian";
	}

	@Override
	public String getTitle(){
		return this.title;
	}

}
