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
	private IPlayerRace playerRace;
	private String name;
	private int healthPoints;
	private String nameWithTitles;
	private IWeapon weapon;
	private Potion potion;
	private Pet pet;
	private String petClassType;
	private Inventory inventory;
	private LevelType level;
	private int experiencePoints;

	public Character(String name, IPlayerRace playerRace, IPlayerClass playerClass) {
		this.name = name;
		this.healthPoints = 100;
		this.playerRace = playerRace;
		this.playerClass = playerClass;
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

	@Column(name = "player_race")
	private Class getPlayerRaceClass() {

		// Gets the playerRace Class object
		return playerRace.getClass();
	}

	private void setPlayerRaceClass(Class playerRaceClass) {

		try {
			// Rehydrates the playerRace object using the Fully Qualified Class Name that was stored in the DB
			// Assigns the rehydrated object to this.playerRace property
			this.playerRace = (IPlayerRace) playerRaceClass.newInstance();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	@Transient
	// the actual playerRace getter
	// ignored by Hibernate, used by code
	public IPlayerRace getPlayerRace(){
		return playerRace;
	}

	// the actual playerRace setter
	// ignored by Hibernate, used by code
	public void setPlayerRace(IPlayerRace playerRace) {
		this.playerRace = playerRace;
	}

	@Column(name = "player_class")
	private Class getPlayerClassClass() {

		// Gets the playerClass Class object
		return playerClass.getClass();
	}

	private void setPlayerClassClass(Class playerClassClass) {
		try {

			// Rehydrates the playerClass object using the Fully Qualified Class Name that was stored in the DB
			// Assigns the rehydrated object to this.playerClass property
			this.playerClass = (IPlayerClass) playerClassClass.newInstance();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	@Transient
	// the actual playerClass getter
	// ignored by Hibernate, used by code
	public IPlayerClass getPlayerClass() {
		return playerClass;
	}

	// the actual playerClass setter
	// ignored by Hibernate, used by code
	public void setPlayerClass(IPlayerClass playerClass) {
		this.playerClass = playerClass;
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


	@Column(name = "weapon_class")
	private Class getWeaponClass() {

		// Gets the weapon Class object
		if (weapon !=null) {
			return weapon.getClass();
		}
		return null;
	}

	private void setWeaponClass(Class weaponClass) {

		try {
			// Rehydrates the weapon object using the Fully Qualified Class Name that was stored in the DB
			// Assigns the rehydrated object to this.weapon property
			this.weapon = (IWeapon) weaponClass.newInstance();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	@Transient
	// the actual weapon getter
	// ignored by Hibernate, used by code
	public IWeapon getWeapon(){
		return this.weapon;
	}

	// the actual weapon setter
	// ignored by Hibernate, used by code
	public void setWeapon(IWeapon weapon) {
		this.weapon = weapon;
	}

	// Rehydrates a potion object when we read the potionClass from the DB
	// Should only be called when reading back from the DB
	@Column(name = "potion_class")
	private Class getPotionClass() {
		if (potion !=null) {
			return potion.getClass();
		}
		return null;
	}

	private void setPotionClass(Class potionClass) {

		try {
			this.potion = (Potion) potionClass.newInstance();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	@Transient
	// the actual potion getter
	// ignored by Hibernate, used by code
	public Potion getPotion() {
		return potion;
	}

	// the actual potion setter
	// ignored by Hibernate, used by code
	public void setPotion(Potion potion) {
		this.potion = potion;
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
