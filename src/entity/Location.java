package src.entity;

import java.util.List;

public class Location {

    private final String name;
    private final String type;
    private final List<Item> items;
    private final List<Character> characters;

    Location(String name, String type, List<Item> items, List<Character> characters) {
        this.name = name;
        this.type = type;
        this.items = items;
        this.characters = characters;

    }
    public String getName() {
        return name;
    }
    public String getType() { return type; }
    public List<Item> getItems() { return items; }
    public List<Character> getCharacters() { return characters; }

}
