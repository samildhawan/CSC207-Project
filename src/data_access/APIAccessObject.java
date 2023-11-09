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

    final List<ChatMessage> messages;

    private static final String API_TOKEN = System.getenv("API_TOKEN");

    public static String getApiToken() {
        return API_TOKEN;
    }

    public APIAccessObject() {
        service = new OpenAiService(getApiToken());
        messages = new ArrayList<>();
    }

    public void clearMessages() {
        messages.clear();
    }

    public void addSystemPrompt(String systemPrompt) {
        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), systemPrompt);
        messages.add(systemMessage);
    }

    public void addUserPrompt(String userPrompt) {
        final ChatMessage requestMessage = new ChatMessage(ChatMessageRole.USER.value(), userPrompt);
        messages.add(requestMessage);
    }

    public void addHistory(String[][] history) {
        for (String[] strings : history) {
            ChatMessage requestMessage = new ChatMessage(ChatMessageRole.USER.value(), strings[0]);
            ChatMessage responseMessage = new ChatMessage(ChatMessageRole.ASSISTANT.value(), strings[1]);
            messages.add(requestMessage);
            messages.add(responseMessage);
        }
    }

    public List<ChatCompletionChoice> runChatGPT() {
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