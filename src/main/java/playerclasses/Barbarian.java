package playerclasses;

import enemy.Enemy;
import interfaces.IMeleeAttack;
import interfaces.IPlayerType;
import items.Weapon;

public class Barbarian implements IPlayerType, IMeleeAttack {

	private String title;
	private Weapon weapon;

	public Barbarian(){
		this.weapon = new Weapon();
		this.title = "Barbarian";
	}

	@Override
	public String getTitle(){
		return this.title;
	}

	@Override
	public Weapon getWeapon(){
		return this.weapon;
	}

	@Override
	public String attack(Enemy enemy){
		return "Hi";
	}
}
