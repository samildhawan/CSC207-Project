package src.entity;
import java.util.Map;

public interface Player {

    String getName();
    int getStat(String stat);
    int getXP();
    String getClassType();
    String getBackstory();
    void addXP(int experience);
    Map<String, Integer> getStats();

}
