package src.data_access;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import src.entity.Player;
import src.entity.PlayerFactory;
import src.use_case.create_player.CreatePlayerDataAccessInterface;
import src.use_case.game.GameDataAccessInterface;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FileDataAccessObject implements CreatePlayerDataAccessInterface, GameDataAccessInterface {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, Player> accounts = new HashMap<>();

    private PlayerFactory playerFactory;

    public FileDataAccessObject(String csvPath, PlayerFactory playerFactory) throws IOException {
        this.playerFactory = playerFactory;

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
                    Player player = playerFactory.create(name, stats, xp, Class, backstory);
                    accounts.put(name, player);
                }
            }
        }
    }

    @Override
    public void save(Player player) {
        accounts.put(player.getName(), player);
        this.save();
    }

    @Override
    public Player get(String username) {
        return accounts.get(username);
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (Player player : accounts.values()) {
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


    /**
     * Return whether a user exists with username identifier.
     * @param identifier the username to check.
     * @return whether a user exists with username identifier
     */
    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

    @Override
    public void addSystemPrompt(String prompt) {

    }

    @Override
    public void addUserPrompt(String prompt) {

    }

    @Override
    public List<ChatCompletionChoice> runChatGPT() {
        return null;
    }

    @Override
    public void clearMessages() {

    }
}

