package items;

import interfaces.IWeapon;

public class Gun implements IWeapon {

    private int attackPoints;

    public Gun() {
        this.attackPoints = 6;
    }

    public int getAttackPoints() {
        return attackPoints;
    }
}
