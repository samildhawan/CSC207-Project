package src.entity;

public class ItemFactory {
    public Item createItem(String type, String name, String additionalAttribute) {
        if (type.equalsIgnoreCase("KEYITEM")) {
            return new KeyItem(name, additionalAttribute);
        } else if (type.equalsIgnoreCase("WEAPON")) {
            return new Weapon(name, additionalAttribute);
        } else {
            return new Wearable(name, additionalAttribute);
        }
    }
}