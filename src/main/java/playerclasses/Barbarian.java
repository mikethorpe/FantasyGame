package playerclasses;
import enemy.Enemy;
import itemsTests.Weapon;
import player.Player;

public class Barbarian extends Player {

	private Weapon weapon;

	public Barbarian(String name){
		super(name);
	}

	public void addWeapon(Weapon weapon){
		this.weapon = weapon;
	}

	public Weapon getWeapon(){
		return this.weapon;
	}

	public String attackEnemy(Enemy enemy){
		int attackPoints = weapon.getAttackPoints();
		return enemy.takeDamage(attackPoints);
	}
}
