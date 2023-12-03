package src.entity;

public class WearableFactory implements ItemFactory {
    @Override
    public Item createItem(String name, String additionalAttribute) {
        return new Wearable(name, additionalAttribute);
    }
}
