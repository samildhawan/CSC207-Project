package src.use_case.create_player;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import src.entity.Player;

import java.util.List;

/**
 * Interface defining data access operations for creating a player.
 */
public interface CreatePlayerDataAccessInterface {

    /**
     * Saves the player information.
     *
     * @param player The player to be saved.
     */
    void save(Player player);
    void save(String name, String backstory);

    /**
     * Retrieves the player information by username.
     *
     * @param username The username of the player to retrieve.
     * @return The player object associated with the username.
     */
    Player get(String username);

    /**
     * Adds a system prompt.
     *
     * @param prompt The system prompt to be added.
     */
    void addSystemPrompt(String prompt);

    /**
     * Adds a user prompt.
     *
     * @param prompt The user prompt to be added.
     */
    void addUserPrompt(String prompt);

    /**
     * Runs the ChatGPT model to generate chat completion choices.
     *
     * @return A list of chat completion choices.
     */
    List<ChatCompletionChoice> runChatGPT();

    /**
     * Clears the chat messages.
     */
    void clearMessages();
}
