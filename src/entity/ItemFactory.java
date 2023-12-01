package src.entity;

public interface ItemFactory {
    Item createItem(String name, String additionalAttribute);
}