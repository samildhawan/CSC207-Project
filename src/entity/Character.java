/**
 * The Character class represents a character in the game world. It encapsulates information
 * about the character's name and relevance within the context of the game.
 *
 * @author Maryann Chen
 * @author Samil Dhawan
 * @author Mohamed Ebsim
 * @since 17.0.8.1
 *
 */

package src.entity;

public class Character {

    private final String name;
    private final String relevance;

    /**
     * Constructs a new Character with the specified name and relevance.
     *
     * @param name      The name of the character.
     * @param relevance The relevance of the character within the context of the game.
     */

    Character(String name, String relevance) {
        this.name = name;
        this.relevance = relevance;
    }

    /**
     * Gets the name of the character.
     *
     * @return The name of the character.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the relevance of the character within the context of the game.
     *
     * @return The relevance of the character.
     */
    public String getRelevance() { return relevance; }

}
