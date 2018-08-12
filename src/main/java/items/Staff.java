package items;

import interfaces.IItem;
import interfaces.IWeapon;

public class Staff implements IWeapon, IItem {

    private int attackPoints;

    public Staff() {
        this.attackPoints = 4;
    }

    public int getAttackPoints() {
        return attackPoints;
    }
}
