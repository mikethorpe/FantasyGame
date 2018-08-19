package character;

import creatures.Pet;
import enemy.Enemy;
import interfaces.*;
import items.Potion;

import java.util.ArrayList;

public class Character {

	private IPlayerClass playerClass;
	private IPlayerRace playerRace;
	private String name;
	private int healthPoints;
	private String nameWithTitles;
	private IWeapon weapon;
	private Potion potion;
	private Pet pet;
	private Inventory inventory;
	private LevelType level;
	private int experiencePoints;

	public Character(String name, IPlayerRace playerRace, IPlayerClass playerClass) {
		this.name = name;
		this.healthPoints = 100;
		this.playerRace = playerRace;
		this.playerClass = playerClass;
		this.weapon = playerClass.getWeapon();
		this.inventory = new Inventory();
		this.level = LevelType.LEVEL_01;
		this.experiencePoints = 0;
		addTitles();
	}

	// getters

	public int getHealthPoints() {
		return healthPoints;
	}

	public String getName() {
		return name;
	}

	public IPlayerClass getPlayerClass(){
		return playerClass;
	}

	public IPlayerRace getPlayerRace(){
		return playerRace;
	}

	public LevelType getLevel() {
		return level;
	}

	public int getExperiencePoints(){
		return experiencePoints;
	}

	public String getNameWithTitles(){
		return this.nameWithTitles;
	}

	public IWeapon getWeapon(){
		return this.weapon;
	}

	public Potion getPotion() {
		return potion;
	}

	public Pet getPet() {
		return pet;
	}

	public int getNumberOfInventoryItems(){
		return this.inventory.getNumberOfItems();
	}

	public ArrayList<IItem> getAllItems(){
		return  inventory.getAllItems();
	}

	// other methods

	public void addTitles(){
		String classTitle = playerClass.getClassTitle();
		String raceTitle = playerRace.getRaceTitle();
		nameWithTitles = this.name + " the " + raceTitle + " " + classTitle;
	}

	public void addPotion(Potion potion){
		this.potion = potion;
	}

	public void addPet(Pet pet){
		this.pet = pet;
	}

	public void updateLevel(){
		for (LevelType level : LevelType.values()){
			if (level.getExperienceRequired() <= this.experiencePoints){
				this.level = level;
			}
		}
	}

	public String attackEnemy(Enemy enemy){
		int attackPoints = weapon.getAttackPoints();
		String response = enemy.takeDamage(attackPoints);
		if (enemy.isDead() == true){
			this.experiencePoints += enemy.getExperiencePointsToAward();
			updateLevel();
		}
		return response;
	}

	public boolean pickUpItem(IItem item){
		return inventory.addItem(item);
	}

	public boolean dropInventoryItem(IItem item){
		return inventory.removeItem(item);
	}

	public void consumeHealthItemFromInventory(IHealthConsumable consumable){
		if (inventory.checkContainsItem(consumable)) {
			healthPoints += consumable.giveHealthPoints();
			dropInventoryItem(consumable);
		}
	}
}
