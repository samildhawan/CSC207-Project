package src.entity;
/**
 * Interface for creating instances of players in the game.
 */
public interface PlayerFactory {

    /**
     * Creates a new player with the given attributes.
     *
     * @param name       The name of the player.
     * @param stats      The statistics of the player.
     * @param xp         The experience points of the player.
     * @param aClass     The class/type of the player.
     * @param backstory  The backstory of the player.
     * @return A new instance of the Player interface.
     */
    Player create(String name, String stats, String xp, String aClass, String backstory);
}
