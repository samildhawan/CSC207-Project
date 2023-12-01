package src.entity;

public class KeyItemFactory implements ItemFactory {
    @Override
    public Item createItem(String name, String additionalAttribute) {
        return new KeyItem(name, additionalAttribute);
    }
}