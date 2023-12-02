/**
 * The Item class is an abstract base class representing an item in the game world.
 * It provides a common structure for different types of items, such as Wearables, KeyItems, and Weapons.
 *
 * @author Maryann Chen
 * @author Samil Dhawan
 * @author Mohamed Ebsim
 * @since 17.0.8.1
 */

package src.entity;
public abstract class Item {
    /**
     * The Item class represents a generic item in the game world.
     * It serves as the base class for specific types of items.
     */
    private final String name;

    /**
     * Constructs a new Item with the specified name.
     *
     * @param name The name of the item.
     */
    public Item(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the item.
     *
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }
}

/**
 * The Wearable class represents an item that can be worn by a character, providing a specific boost.
 */
class Wearable extends Item {
    private final String boost;

    /**
     * Constructs a new Wearable with the specified name and boost.
     *
     * @param name  The name of the wearable item.
     * @param boost The boost provided by wearing the item.
     */
    public Wearable(String name, String boost) {
        super(name);
        this.boost = boost;
    }

    /**
     * Gets the boost provided by wearing the item.
     *
     * @return The boost provided by the wearable item.
     */
    public String getBoost() {
        return boost;
    }
}


/**
 * The KeyItem class represents a special item that is essential to the progression of the game.
 */
class KeyItem extends Item {
    private final String importance;

    /**
     * Constructs a new KeyItem with the specified name and importance.
     *
     * @param name       The name of the key item.
     * @param importance The importance or significance of the key item.
     */
    public KeyItem(String name, String importance) {
        super(name);
        this.importance = importance;
    }

    /**
     * Gets the importance or significance of the key item.
     *
     * @return The importance of the key item.
     */
    public String getImportance() {
        return importance;
    }
}

/**
 * The Weapon class represents an item that can be used as a weapon, causing a specific amount of damage.
 */

class Weapon extends Item {
    private final String damage;

    /**
     * Constructs a new Weapon with the specified name and damage.
     *
     * @param name   The name of the weapon.
     * @param damage The damage caused by using the weapon.
     */
    public Weapon(String name, String damage) {
        super(name);
        this.damage = damage;
    }

    /**
     * Gets the damage caused by using the weapon.
     *
     * @return The damage caused by the weapon.
     */
    public String getDamage() {
        return damage;
    }
}
