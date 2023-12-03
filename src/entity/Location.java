/**
 * The Location class represents a location within the game world. It encapsulates information
 * about the location's name, type, items, and characters present in the location.
 *
 * @author Maryann Chen
 * @author Samil Dhawan
 * @author Mohamed Ebsim
 * @since 17.0.8.1
 *
 */

package src.entity;

import java.util.List;

public class Location {

    private final String name;
    private final String type;
    private final List<Item> items;
    private final List<Character> characters;

    /**
     * Constructs a new Location with the specified name, type, items, and characters.
     *
     * @param name       The name of the location.
     * @param type       The type or category of the location.
     * @param items      The list of items present in the location.
     * @param characters The list of characters present in the location.
     */
    Location(String name, String type, List<Item> items, List<Character> characters) {
        this.name = name;
        this.type = type;
        this.items = items;
        this.characters = characters;

    }

    /**
     * Gets the name of the location.
     *
     * @return The name of the location.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the type or category of the location.
     *
     * @return The type of the location.
     */
    public String getType() { return type; }

    /**
     * Gets the list of items present in the location.
     *
     * @return The list of items in the location.
     */
    public List<Item> getItems() { return items; }

    /**
     * Gets the list of characters present in the location.
     *
     * @return The list of characters in the location.
     */
    public List<Character> getCharacters() { return characters; }

}
