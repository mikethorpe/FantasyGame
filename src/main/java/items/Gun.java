package items;

import interfaces.IItem;
import interfaces.IWeapon;

public class Gun implements IWeapon, IItem {

    private int attackPoints;

    public Gun() {
        this.attackPoints = 6;
    }

    public int getAttackPoints() {
        return attackPoints;
    }
}
