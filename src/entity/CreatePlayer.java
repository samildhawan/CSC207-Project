package src.entity;
import java.util.HashMap;
import java.util.Map;

public class CreatePlayer implements Player{
    private String name;
    private int level;
    private int xp;
    private String classType;
    private String backstory;
    private Map<String, Integer> stats;

    // Constructor to initialize player attributes
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
    public String getClassType() {
        return classType;
    }

    @Override
    public String getBackstory() {
        return backstory;
    }

    @Override
    public void addXP(int experience) {
        this.xp += experience;
    }

    @Override
    public Map<String, Integer> getStats() {
        return stats;
    }

    // Other overridden methods (getStat, getXP, getClassType, getBackstory, addXP, getStats)
    // ...

    // Additional methods or helper methods as needed
    private void initializeStats() {
        // Initialize player stats as needed
        // For example:
        this.stats.put("HP", 100);
        this.stats.put("Strength", 10);
        // Add more stats as required
    }
}
