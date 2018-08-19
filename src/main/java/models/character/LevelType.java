package character;

public enum LevelType {

    LEVEL_01(1, 0),
    LEVEL_02(2, 100),
    LEVEL_03(3, 200),
    LEVEL_04(4, 300),
    LEVEL_05(5, 400),
    LEVEL_06(6, 500),
    LEVEL_07(7, 600),
    LEVEL_08(8, 700),
    LEVEL_09(9, 800),
    LEVEL_10(10, 900);

    private final int level;
    private final int experiencePoints;

    LevelType(int level, int experiencePoints){
        this.level = level;
        this.experiencePoints = experiencePoints;
    }

    public int getExperienceRequired(){
        return this.experiencePoints;
    }

}
