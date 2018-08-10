package player;

import creatures.Pet;
import enemy.Enemy;
import interfaces.IPlayerType;
import items.Potion;
import items.Weapon;

public class Player {

	private IPlayerType playerType;
	private String name;
	private int healthPoints;
	private String nameWithTitle;
	private Weapon weapon;
	private Potion potion;
	private Pet pet;

	public Player(String name, IPlayerType playerType) {
		this.name = name;
		this.healthPoints = 100;
		this.playerType = playerType;
		this.weapon = playerType.getWeapon();
		addTitle();
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

	public void addTitle(){
		String title = playerType.getTitle();
		nameWithTitle = this.name + " the " + title;
	}

	public String getNameWithTitle(){
		return this.nameWithTitle;
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
