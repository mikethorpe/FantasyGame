package models.playerraces;

import models.interfaces.IPlayerRace;

public class Elf implements IPlayerRace {

    private String raceTitle;

    public Elf(){
        this.raceTitle = "Elven";
    }

    public String getRaceTitle(){
        return this.raceTitle;
    }
}
