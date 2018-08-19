package playerraces;

import interfaces.IPlayerRace;

public class Human implements IPlayerRace {

    private String raceTitle;

    public Human(){
        this.raceTitle = "Human";
    }

    public String getRaceTitle(){
        return this.raceTitle;
    }
}
