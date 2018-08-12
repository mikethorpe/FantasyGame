package items;

import interfaces.IWeapon;

public class Staff implements IWeapon {

    private int attackPoints;

    public Staff() {
        this.attackPoints = 4;
    }

    public int getAttackPoints() {
        return attackPoints;
    }
}
