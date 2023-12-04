package src.entity;

import java.util.Map;

/**
 * Interface representing a player in the game.
 */
public interface Player {

    /**
     * Gets the name of the player.
     *
     * @return The name of the player.
     */
    String getName();

    /**
     * Gets the value of a specific statistic of the player.
     *
     * @param stat The statistic to retrieve.
     * @return The value of the specified statistic.
     */
    int getStat(String stat);

    /**
     * Gets the experience points of the player.
     *
     * @return The experience points of the player.
     */
    int getXP();

    /**
     * Gets the class/type of the player.
     *
     * @return The class/type of the player.
     */
    String getClassType();

    /**
     * Gets the backstory of the player.
     *
     * @return The backstory of the player.
     */
    String getBackstory();

    /**
     * Adds experience points to the player.
     *
     * @param experience The amount of experience points to add.
     */
    void addXP(int experience);

    /**
     * Gets the statistics of the player.
     *
     * @return A map containing the statistics of the player.
     */
    Map<String, Integer> getStats();
}
