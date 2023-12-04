package src.entity;

public interface PlayerBuilder {

    void newPlayer();
    void addName(String name);
    void addBackstory(String backstory);
    void initializeStats();
    Player getPlayer();

}
