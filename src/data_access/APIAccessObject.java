package src.data_access;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;

import java.util.ArrayList;
import java.util.List;

public class APIAccessObject {

    // TODO: Fill this in

    // THIS IS EXAMPLE CODE
    private static final String API_TOKEN = System.getenv("API_TOKEN");

    public static String getApiToken() {
        return API_TOKEN;
    }

    public static void runChatGPT() {
        OpenAiService service = new OpenAiService(getApiToken());
        final List<ChatMessage> messages = new ArrayList<>();
        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), "You are an assistant for a dungeon master for a simplified version of Dungeons & Dragons. You need to be concise and accurate, limiting your statements to a short sentence or just numbers.");
        final ChatMessage requestMessage = new ChatMessage(ChatMessageRole.USER.value(), "Generate the stats for an enemy that a level 1 warrior can fight.");
        messages.add(systemMessage);
        messages.add(requestMessage);
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo")
                .messages(messages)
                .build();

        service.createChatCompletion(chatCompletionRequest).getChoices().forEach(System.out::println);
    }
}
