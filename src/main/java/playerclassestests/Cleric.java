package playerclassestests;

import interfaces.IPlayerType;

public class Cleric implements IPlayerType {

	private String title;

	public Cleric() {
		this.title = "Cleric";
	}

	@Override
	public String getTitle() {
		return title;
	}
}
