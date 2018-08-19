package models.enemy;

public abstract class Enemy {

	private int healthPoints;
	private boolean isDead;
	protected int experiencePointsToAward;

	public Enemy() {
		this.healthPoints = 100;
		this.isDead = false;
		this.experiencePointsToAward = 0;
	}

	public int getHealthPoints(){
		return this.healthPoints;
	}

	public int getExperiencePointsToAward(){
		return experiencePointsToAward;
	}

	public String takeDamage(int attackPoints){
		this.healthPoints -= attackPoints;
		if (this.healthPoints <= 0){
			this.isDead = true;
			return "You killed the enemy!";
		}
		return "You hit the enemy and reduced its health by " + attackPoints + " points!";
	}

	public boolean isDead(){
		return this.isDead;
	}

}
