package player;

public abstract class Player {

	private int healthPoints;
	private String name;

	public Player(String name) {
		this.name = name;
		this.healthPoints = 100;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public String getName() {
		return name;
	}

}
