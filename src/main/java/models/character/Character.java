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
		this.weapon = playerClass.getWeapon();
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
			this.playerRace = (IPlayerRace) playerRaceClass.getDeclaredConstructor().newInstance();
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
			this.playerClass = (IPlayerClass) playerClassClass.getDeclaredConstructor().newInstance();
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
			this.weapon = (IWeapon) weaponClass.getDeclaredConstructor().newInstance();
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

	@Column(name = "potion_class")
	private Class getPotionClass() {
		if (potion !=null) {

			// Gets the potion Class object
			return potion.getClass();
		}
		return null;
	}

	private void setPotionClass(Class potionClass) {

		try {
			// Rehydrates the potion object using the Fully Qualified Class Name that was stored in the DB
			// Assigns the rehydrated object to this.potion property
			this.potion = (Potion) potionClass.getDeclaredConstructor().newInstance();
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

	@Column(name = "pet_class")
	private Class getPetClass() {
		if (pet!=null) {

			// Gets the pet Class object
			return pet.getClass();
		}
		return null;
	}

	private void setPetClass(Class petClass) {

		try {

			// Rehydrates the pet object using the Fully Qualified Class Name that was stored in the DB
			// Assigns the rehydrated object to this.pet property
			this.pet = (Pet) petClass.getDeclaredConstructor().newInstance();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	@Transient
	// the actual pet getter
	// ignored by Hibernate, used by code
	public Pet getPet() {
		return pet;
	}

	// the actual pet setter
	// ignored by Hibernate, used by code
	public void setPet(Pet pet) {
		this.pet = pet;
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
