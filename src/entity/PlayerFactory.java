package src.entity;

public interface PlayerFactory {

    Player create(String name, String stats, String xp, String aClass, String backstory);
}
