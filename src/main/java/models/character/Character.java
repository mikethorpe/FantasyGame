package models.character;

import models.creatures.Pet;
import models.enemy.Enemy;
import models.interfaces.*;
import models.items.Potion;
import models.playerclasses.Barbarian;
import models.playerraces.Dwarf;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="characters")
public class Character {

	private int id;
	private IPlayerClass playerClass;
	private IPlayerRace playerRace;
	private String playerRaceClassType;
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
		setPlayerRace(playerRace);
		setPlayerClass(playerClass);
		this.weapon = playerClass.getWeapon();
		this.inventory = new Inventory();
		this.level = LevelType.LEVEL_01;
		this.experiencePoints = 0;
		addTitles();
	}

	public Character(){

	}

	// getters and setters


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="health_points")
	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Column(name = "playerRaceClassType")
	private String getPlayerRaceClassType() {
		return playerRaceClassType;
	}

	// Rehydrates a playerRace object when we read the playerRaceClassType from the DB
	// Should only be called when reading back from the DB
	private void setPlayerRaceClassType(String playerRaceClassType) {

		try {
			Class playerRaceClass  = Class.forName(playerRaceClassType);
			this.playerRace = (IPlayerRace) playerRaceClass.newInstance();
		}
		catch (Exception e){
			e.printStackTrace();
		}

		this.playerRaceClassType = playerRaceClassType;
	}


	@Transient
	public IPlayerRace getPlayerRace(){
		return playerRace;
	}

	public void setPlayerRace(IPlayerRace playerRace) {
		this.playerRace = playerRace;
		this.playerRaceClassType = playerRace.getClass().toString();
	}


	private String playerClassClassType;

	// Rehydrates a playerClass object when we read the playerClassClassType from the DB
	// Should only be called when reading back from the DB
	@Column(name = "playerClassClassType")
	public String getPlayerClassClassType() {
		return playerClassClassType;
	}

	public void setPlayerClassClassType(String playerClassClassType) {

		try {
			Class playerClassClass = Class.forName(playerClassClassType);
			this.playerClass = (IPlayerClass) playerClassClass.newInstance();
		}
		catch (Exception e){
			e.printStackTrace();
		}

		this.playerClassClassType = playerClassClassType;
	}

	@Transient
	public IPlayerClass getPlayerClass() {
		return playerClass;
	}

	public void setPlayerClass(IPlayerClass playerClass) {
		this.playerClass = playerClass;
		this.playerClassClassType = playerClass.getClass().toString();
	}

	@Enumerated( value = EnumType.STRING)
	public LevelType getLevel() {
		return level;
	}

	public void setLevel(LevelType level) {
		this.level = level;
	}

	@Column(name="experience_points")
	public int getExperiencePoints(){
		return experiencePoints;
	}

	public void setExperiencePoints(int experiencePoints) {
		this.experiencePoints = experiencePoints;
	}

	@Column(name="name_with_titles")
	public String getNameWithTitles(){
		return this.nameWithTitles;
	}

	public void setNameWithTitles(String nameWithTitles) {
		this.nameWithTitles = nameWithTitles;
	}

//	// @dont know yet
//	public IWeapon getWeapon(){
//		return this.weapon;
//	}
//
//	public void setWeapon(IWeapon weapon) {
//		this.weapon = weapon;
//	}

//	@Column(name="potion")
//	public Potion getPotion() {
//		return potion;
//	}
//
//	public void setPotion(Potion potion) {
//		this.potion = potion;
//	}

//	@Column(name="pet")
//	public Pet getPet() {
//		return pet;
//	}
//
//	public void setPet(Pet pet) {
//		this.pet = pet;
//	}
//
//	@Column(name="inventory")
//	public Inventory getInventory() {
//		return inventory;
//	}
//
//	public void setInventory(Inventory inventory) {
//		this.inventory = inventory;
//	}

	public int numberOfInventoryItems(){
		return this.inventory.getNumberOfItems();
	}

	public ArrayList<IItem> acquireAllItems(){
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
