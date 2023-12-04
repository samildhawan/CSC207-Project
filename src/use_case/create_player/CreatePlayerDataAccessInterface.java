package src.use_case.create_player;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import src.entity.Player;

import java.util.List;

public interface CreatePlayerDataAccessInterface {
    void save(Player player);
    void save(String name, String backstory);
    Player get(String username);
    void addSystemPrompt(String prompt);
    void addUserPrompt(String prompt);
    List<ChatCompletionChoice> runChatGPT();
    void clearMessages();
}
