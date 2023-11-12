package src.use_case.game;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;

import java.util.List;

public class GameOutputData {

    final List<ChatCompletionChoice> choices;

    public GameOutputData(List<ChatCompletionChoice> choices) {
        this.choices = choices;
    }

    public String getMessage() {
        return choices.get(0).getMessage().getContent();
    }

}
