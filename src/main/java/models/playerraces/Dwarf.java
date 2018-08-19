package models.playerraces;

import models.interfaces.IPlayerRace;

public class Dwarf implements IPlayerRace {

    private String raceTitle;

    public Dwarf(){
        this.raceTitle = "Dwarven";
    }

    public String getRaceTitle(){
        return this.raceTitle;
    }
}
