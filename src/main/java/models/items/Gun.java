package models.items;

import models.interfaces.IItem;
import models.interfaces.IWeapon;

public class Gun implements IWeapon, IItem {

    private String name;

    private int attackPoints;

    public Gun() {
        this.attackPoints = 6;
        this.name = "Gun";
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    @Override
    public String getName(){
        return this.name;
    }
}
