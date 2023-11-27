package src.use_case.create_player;
import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import java.util.List;

public class CreatePlayerOutputData {

    final List<ChatCompletionChoice> choices;
    public CreatePlayerOutputData(List<ChatCompletionChoice> choices) {
        this.choices = choices;
    }

    public String getMessage() {
        return choices.get(0).getMessage().getContent();
    }
}
