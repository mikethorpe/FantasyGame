package models.character;
import models.creatures.Pet;
import models.enemy.Enemy;
import models.interfaces.*;
import models.items.Potion;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="characters")
public class Character {

	private int id;
	private IPlayerClass playerClass;
	private String playerClassClassType;
	private IPlayerRace playerRace;
	private String playerRaceClassType;
	private String name;
	private int healthPoints;
	private String nameWithTitles;
	private IWeapon weapon;
	private String weaponClassType;
	private Potion potion;
	private String potionClassType;
	private Pet pet;
	private String petClassType;
	private Inventory inventory;
	private LevelType level;
	private int experiencePoints;

	public Character(String name, IPlayerRace playerRace, IPlayerClass playerClass) {
		this.name = name;
		this.healthPoints = 100;
		setPlayerRace(playerRace);
		setPlayerClass(playerClass);
		setWeapon(playerClass.getWeapon());
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

	// Rehydrates a playerClass object when we read the playerClassClassType from the DB
	// Should only be called when reading back from the DB
	@Column(name = "playerClassClassType")
	private String getPlayerClassClassType() {
		return playerClassClassType;
	}

	private void setPlayerClassClassType(String playerClassClassType) {

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

	// Rehydrates a weapon object when we read the weaponClass from the DB
	// Should only be called when reading back from the DB
	@Column(name = "weaponClassType")
	private String getWeaponClassType() {
		return weaponClassType;
	}

	private void setWeaponClassType(String weaponClassType) {

		try {
			Class weaponClass = Class.forName(weaponClassType);
			this.weapon = (IWeapon) weaponClass.newInstance();
		}
		catch (Exception e){
			e.printStackTrace();
		}

		this.weaponClassType = weaponClassType;
	}

	@Transient
	public IWeapon getWeapon(){
		return this.weapon;
	}

	public void setWeapon(IWeapon weapon) {
		this.weapon = weapon;
		this.weaponClassType = weapon.getClass().toString();
	}

	// Rehydrates a potion object when we read the potionClass from the DB
	// Should only be called when reading back from the DB
	@Column(name = "potionClassType")
	private String getPotionClassType() {
		return potionClassType;
	}

	private void setPotionClassType(String potionClassType) {

		try {
			Class potionClass = Class.forName(potionClassType);
			this.potion = (Potion) potionClass.newInstance();
		}
		catch (Exception e){
			e.printStackTrace();
		}

		this.potionClassType = potionClassType;
	}

	@Transient
	public Potion getPotion() {
		return potion;
	}

	public void setPotion(Potion potion) {
		this.potion = potion;
		this.potionClassType = potion.getClass().toString();
	}


	// Rehydrates a pet object when we read the petClassType from the DB
	// Should only be called when reading back from the DB
	@Column(name = "petClassType")
	private String getPetClassType() {
		return petClassType;
	}

	private void setPetClassType(String petClassType) {

		try {
			Class petClass = Class.forName(petClassType);
			this.pet = (Pet) petClass.newInstance();
		}
		catch (Exception e){
			e.printStackTrace();
		}

		this.petClassType = petClassType;
	}

	@Transient
	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
		this.petClassType = pet.getClass().toString();
	}


	@Transient
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	@Transient
	public int getNumberOfInventoryItems(){
		return this.inventory.getNumberOfItems();
	}

	@Transient
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
		setPotion(potion);
	}

	public void addPet(Pet pet){
		setPet(pet);
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
