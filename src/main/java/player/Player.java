package player;

import creatures.Pet;
import enemy.Enemy;
import interfaces.IPlayerType;
import itemsTests.Potion;
import itemsTests.Weapon;

public class Player {

	private int healthPoints;
	private String name;
	private IPlayerType playerType;
	private Weapon weapon;
	private Potion potion;
	private Pet pet;

	public Player(String name, IPlayerType playerType) {
		this.name = name;
		this.healthPoints = 100;
		this.playerType = playerType;
		//addTitle();
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public String getName() {
		return name;
	}

	public IPlayerType getPlayerType(){
		return playerType;
	}

//	private void addTitle(){
//		String title = playerType.
//	}

	public void addWeapon(Weapon weapon){
		this.weapon = weapon;
	}

	public Weapon getWeapon(){
		return this.weapon;
	}

	public Potion getPotion() {
		return potion;
	}

	public void addPotion(Potion potion){
		this.potion = potion;
	}

	public Pet getPet() {
		return pet;
	}

	public void addPet(Pet pet){
		this.pet = pet;
	}

	public String attackEnemy(Enemy enemy){
		int attackPoints = weapon.getAttackPoints();
		return enemy.takeDamage(attackPoints);
	}
}
