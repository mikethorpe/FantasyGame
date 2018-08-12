package character;

import creatures.Pet;
import enemy.Enemy;
import interfaces.IItem;
import interfaces.IPlayerClass;
import interfaces.IPlayerRace;
import interfaces.IWeapon;
import itemstests.Potion;

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

	public Character(String name, IPlayerRace playerRace, IPlayerClass playerType) {
		this.name = name;
		this.healthPoints = 100;
		this.playerRace = playerRace;
		this.playerClass = playerType;
		this.weapon = playerType.getWeapon();
		this.inventory = new Inventory();
		addTitles();
	}

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

	public void addTitles(){
		String classTitle = playerClass.getClassTitle();
		String raceTitle = playerRace.getRaceTitle();
		nameWithTitles = this.name + " the " + raceTitle + " " + classTitle;
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

	public void pickUpItem(IItem item){
		inventory.addItem(item);
	}

	public int getNumberOfInventoryItems(){
		return this.inventory.getNumberOfItems();
	}

	public ArrayList<IItem> getAllItems(){
		return  inventory.getAllItems();
	}

	public boolean dropInventoryItem(IItem item){
		return inventory.removeItem(item);
	}

}
