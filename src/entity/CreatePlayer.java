package src.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a CreatePlayer implementing the Player interface with specific attributes.
 */
public class CreatePlayer implements Player {
    private String name;
    private int level;
    private int xp;
    private String classType;
    private String backstory;
    private Map<String, Integer> stats;

    /**
     * Constructor to initialize player attributes.
     *
     * @param name       The name of the player.
     * @param classType  The type/class of the player.
     * @param backstory  The backstory of the player.
     */
    public CreatePlayer(String name, String classType, String backstory) {
        this.name = name;
        this.classType = classType;
        this.backstory = backstory;
        this.level = 1; // Assuming initial level is 1
        this.xp = 0;    // Assuming initial XP is 0
        this.stats = new HashMap<>();
        initializeStats(); // Initialize stats
    }

    // Implement methods from Player interface

    /**
     * Retrieves the name of the player.
     *
     * @return The name of the player.
     */
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStat(String stat) {
        return 0;
    }

    @Override
    public int getXP() {
        return 0;
    }

    @Override
    public String getClassType() {
        return null;
    }

    @Override
    public String getBackstory() {
        return null;
    }

    // Other overridden methods from Player interface...

    /**
     * Adds experience points to the player.
     *
     * @param experience The amount of experience points to add.
     */
    @Override
    public void addXP(int experience) {
        // Add experience logic
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

    // Other overridden methods from Player interface...

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
