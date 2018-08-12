package character;

public enum LevelType {

    LEVEL_01(1, 100),
    LEVEL_02(2, 200),
    LEVEL_03(3, 300),
    LEVEL_04(4, 400),
    LEVEL_05(5, 500),
    LEVEL_06(6, 600),
    LEVEL_07(7, 700),
    LEVEL_08(8, 800),
    LEVEL_09(9, 900),
    LEVEL_10(10, 1000);

    private final int level;
    private final int experiencePoints;

    LevelType(int level, int experiencePoints){
        this.level = level;
        this.experiencePoints = experiencePoints;
    }

}
