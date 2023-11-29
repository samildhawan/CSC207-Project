package src.entity;

public class Character {

    private final String name;
    private final String relevance;

    Character(String name, String relevance) {
        this.name = name;
        this.relevance = relevance;
    }
    public String getName() {
        return name;
    }
    public String getRelevance() { return relevance; }

}
