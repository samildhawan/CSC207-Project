package src.data_access;

import com.theokanning.openai.completion.chat.*;
import com.theokanning.openai.service.OpenAiService;
import src.entity.Player;
import src.entity.PlayerBuilder;
import src.entity.ShortTermWorldStory;
import src.entity.WorldStory;
import src.use_case.create_player.CreatePlayerDataAccessInterface;
import src.use_case.game.GameDataAccessInterface;

import java.io.*;
import java.time.Duration;
import java.util.*;

public class APIAccessObject implements GameDataAccessInterface, CreatePlayerDataAccessInterface {

    private final OpenAiService service;

    final List<ChatMessage> messages;

    private static final String API_TOKEN = System.getenv("API_TOKEN");

    public static String getApiToken() {
        return API_TOKEN;
    }

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, Player> players = new HashMap<>();

    private PlayerBuilder playerBuilder;

    private WorldStory worldStory = new ShortTermWorldStory();

    public APIAccessObject() {
        service = new OpenAiService(getApiToken(), Duration.ZERO);
        messages = new ArrayList<>();

        csvFile = null;
    }

    public APIAccessObject(String csvPath, PlayerBuilder playerBuilder) {
        service = new OpenAiService(getApiToken(), Duration.ZERO);
        messages = new ArrayList<>();

        this.playerBuilder = playerBuilder;

        csvFile = new File(csvPath);
        headers.put("Name", 0);
        headers.put("Stats", 1);
        headers.put("XP", 2);
        headers.put("Class", 3);
        headers.put("Backstory", 4);

        if (csvFile.length() == 0) {
            save();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();


                assert header.equals("Name,Stats,XP,Class,Backstory");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String name = String.valueOf(col[headers.get("Name")]);
                    String stats = String.valueOf(col[headers.get("Stats")]);
                    String xp = String.valueOf(col[headers.get("XP")]);
                    String Class = String.valueOf(col[headers.get("Class")]);
                    String backstory = String.valueOf(col[headers.get("Backstory")]);
                    playerBuilder.newPlayer();
                    playerBuilder.addName(name);
                    playerBuilder.addBackstory(backstory);
                    playerBuilder.initializeStats();
                    players.put(name, playerBuilder.getPlayer());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void clearMessages() {
        messages.clear();
    }

    @Override
    public void save(Player player) {
        players.put(player.getName(), player);
        this.save();
    }

    @Override
    public Player get(String username) {
        return players.get(username);
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (Player player : players.values()) {
                String line = String.format("%s,%s,%s,%s,%s",
                        player.getName(), player.getStats(), player.getXP(), player.getClassType(), player.getBackstory());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Player getPlayer() {
        if (players.isEmpty()) {
            playerBuilder.newPlayer();
            playerBuilder.addName("Jim");
            playerBuilder.addBackstory("Came from somewhere");
            playerBuilder.initializeStats();
            players.put("Jim", playerBuilder.getPlayer());
            return playerBuilder.getPlayer();
        }
        for (Player player : players.values()) {
            return player;
        }
        return null;
    }

    @Override
    public WorldStory getWorldStory() {
        return worldStory;
    }

    public void addSystemPrompt(String systemPrompt) {
        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), systemPrompt);
        messages.add(systemMessage);
    }

    public void addUserPrompt(String userPrompt) {
        final ChatMessage requestMessage = new ChatMessage(ChatMessageRole.USER.value(), userPrompt);
        messages.add(requestMessage);
    }

    public void addHistory(List<String[]> history) {
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

        ChatCompletionResult result = service.createChatCompletion(chatCompletionRequest);
        System.out.println("USAGE " + result.getUsage().getTotalTokens());

        return result.getChoices();
    }
}
