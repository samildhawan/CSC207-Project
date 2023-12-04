package src.entity;

import java.util.List;

public interface WorldStory {

    void addEvent(String event);
    String getEvent();
    void addHistory(String history[]);
    List<String[]> getHistory();
    String getPrompt();

}
