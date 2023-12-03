package src.entity;

public class WeaponFactory implements ItemFactory {
    @Override
    public Item createItem(String name, String additionalAttribute) {
        return new Weapon(name, additionalAttribute);
    }
}
