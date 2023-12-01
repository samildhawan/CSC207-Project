package src.entity;

public abstract class Item {
    private final String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

// Concrete class for Wearable item
class Wearable extends Item {
    private final String boost;
    public Wearable(String name, String boost) {
        super(name);
        this.boost = boost;
    }

    public String getBoost() {
        return boost;
    }

}

class KeyItem extends Item {
    private final String importance;
    public KeyItem(String name, String importance) {
        super(name);
        this.importance = importance;
    }

    public String getImportance() {
        return importance;
    }
}

class Weapon extends Item {
    private final String damage;
    public Weapon(String name, String damage) {
        super(name);
        this.damage = damage;
    }
    public String getDamage() {
        return damage;
    }
}
