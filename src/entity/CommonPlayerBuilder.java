package src.entity;

import java.util.HashMap;
import java.util.Map;

public class CommonPlayerBuilder implements PlayerBuilder {

    private Player player;

    public void newPlayer() {
        player = new CommonPlayer();
    }

    public void addName(String name) {player.setName(name);}

    public void addBackstory(String backstory) {player.setBackstory(backstory); }

    public void initializeStats() {
        player.setClassType("Warrior");
        Map<String, Integer> stats = new HashMap<>();
        stats.put("HP", 100);
        stats.put("Strength", 10);
        player.setStats(stats);
    }

    @Override
    public Player getPlayer() {
        return player;
    }

}
