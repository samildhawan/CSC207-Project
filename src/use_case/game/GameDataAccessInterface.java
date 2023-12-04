package src.use_case.game;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import src.entity.Player;
import src.entity.WorldStory;

import java.util.List;

public interface GameDataAccessInterface {


    Player getPlayer();
    WorldStory getWorldStory();
    void addHistory(List<String[]> history);
    void addSystemPrompt(String prompt);

    void addUserPrompt(String prompt);

    List<ChatCompletionChoice> runChatGPT();

    void clearMessages();

}
