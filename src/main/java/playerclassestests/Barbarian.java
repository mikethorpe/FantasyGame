package playerclassestests;

import interfaces.IPlayerType;

public class Barbarian implements IPlayerType {

	private String title;

	public Barbarian(){
		title = "Barbarian";
	}

	public String getTitle(){
		return this.title;
	}

}
