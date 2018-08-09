package player;

import playerclasses.PlayerType;

public class Player {

	private int healthPoints;
	private String name;
	private PlayerType playerType;

	public Player(String name, PlayerType playerType) {
		this.name = name;
		this.healthPoints = 100;
		this.playerType = playerType;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public String getName() {
		return name;
	}

	public PlayerType getPlayerType(){
		return playerType;
	}
}
