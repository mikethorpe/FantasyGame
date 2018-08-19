package models.items;

import models.interfaces.IItem;
import models.interfaces.IWeapon;

public class Staff implements IWeapon, IItem {

    private String name;
    private int attackPoints;

    public Staff() {
        this.attackPoints = 4;
        this.name = "Staff";
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    @Override
    public String getName(){
        return this.name;
    }
}
