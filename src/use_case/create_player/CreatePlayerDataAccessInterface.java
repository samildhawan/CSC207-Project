package src.use_case.create_player;

import java.util.List;

public interface CreatePlayerDataAccessInterface {
    void addSystemPrompt(String prompt);
    void addUserPrompt(String prompt);
    List<ChatCompletionChoice> runChatGPT();
    void clearMessages();
}
