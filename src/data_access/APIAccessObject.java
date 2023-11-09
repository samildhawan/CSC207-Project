package src.data_access;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;

import java.util.ArrayList;
import java.util.List;

public class APIAccessObject {

    private final OpenAiService service;

    private static final String API_TOKEN = System.getenv("API_TOKEN");

    public static String getApiToken() {
        return API_TOKEN;
    }

    public APIAccessObject() {
        service = new OpenAiService(getApiToken());
    }


    public List<ChatCompletionChoice> runChatGPT(String systemPrompt, String userPrompt) {
        // Create a list of the System and Chat messages
        final List<ChatMessage> messages = new ArrayList<>();
        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), systemPrompt);
        final ChatMessage requestMessage = new ChatMessage(ChatMessageRole.USER.value(), userPrompt);
        messages.add(systemMessage);
        messages.add(requestMessage);

        // Create the chat request
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo")
                .messages(messages)
                .build();

        // Return all the ChatCompletionChoices
        // A ChatCompletionChoice includes the message, the finishReason and the index
        return service.createChatCompletion(chatCompletionRequest).getChoices();
    }
}
