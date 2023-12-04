package src.entity;

import java.util.Map;

/**
 * Represents a CommonPlayer implementing the Player interface with specific attributes.
 */
public class CommonPlayer implements Player {

    private String name;
    private int level = 1;
    private int xp = 0;
    private String classType;
    private String backstory;
    private Map<String, Integer> stats;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStat(String stat) {
        return stats.get(stat);
    }

    @Override
    public int getXP() {
        return xp;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public String getClassType() {
        return classType;
    }

    @Override
    public String getBackstory() {
        return backstory;
    }

    // Other overridden methods from Player interface...

    /**
     * Adds experience points to the player.
     *
     * @param experience The amount of experience points to add.
     */
    @Override
    public void addXP(int experience) {
        this.xp += experience;
    }

    /**
     * Retrieves the player's statistics.
     *
     * @return The player's statistics as a Map of String keys and Integer values.
     */
    @Override
    public Map<String, Integer> getStats() {
        return stats;
    }

    @Override
    public void setStats(Map<String, Integer> stats) {
        this.stats = stats;
    }

    @Override
    public void setBackstory(String backstory) {
        this.backstory = backstory;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setClassType(String classType) {
        this.classType = classType;
    }

    // Other overridden methods (getStat, getXP, getClassType, getBackstory, addXP, getStats)
    // ...

    // Additional methods or helper methods as needed

    /**
     * Initializes player statistics.
     * Example: Initializes HP and Strength.
     */
    private void initializeStats() {
        // Initialize player stats as needed
        // For example:
        this.stats.put("HP", 100);
        this.stats.put("Strength", 10);
        // Add more stats as required
    }
}
