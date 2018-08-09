package enemy;

public abstract class Enemy {

	private int healthPoints;

	public Enemy() {
		this.healthPoints = 100;
	}

	public int getHealthPoints(){
		return this.healthPoints;
	}

	public String takeDamage(int attackPoints){
		this.healthPoints -= attackPoints;
		return "Ouch, that hurt by exactly " + attackPoints + " points!";
	}
}
