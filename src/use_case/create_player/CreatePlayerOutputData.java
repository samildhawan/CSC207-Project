package src.use_case.create_player;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import java.util.List;

/**
 * Represents the output data for creating a player.
 */
public class CreatePlayerOutputData {

    private final List<ChatCompletionChoice> choices;

    /**
     * Constructor for CreatePlayerOutputData.
     *
     * @param choices The list of chat completion choices.
     */
    public CreatePlayerOutputData(List<ChatCompletionChoice> choices) {
        this.choices = choices;
    }

    /**
     * Retrieves the message content from the first choice.
     *
     * @return The content of the message.
     */
    public String getMessage() {
        return choices.get(0).getMessage().getContent();
    }
}

