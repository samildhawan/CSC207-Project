package src.entity;
import java.util.Map;

public interface Player {

    String getName();
    int getStat(String stat);
    int getXP();
    int getLevel();
    String getClassType();
    String getBackstory();
    void addXP(int experience);
    Map<String, Integer> getStats();

    void setStats(Map<String, Integer> stats);

    void setBackstory(String backstory);
    void setName(String name);
    void setClassType(String classType);

}
