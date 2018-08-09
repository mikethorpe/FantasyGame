package playerclasses;

import creatures.Pet;
import enemy.Enemy;
import itemsTests.Potion;
import itemsTests.Weapon;

public abstract class PlayerType {

	private Weapon weapon;
	private Potion potion;
	private Pet pet;

	public PlayerType(){

	}

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
