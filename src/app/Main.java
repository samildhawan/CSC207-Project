package src.app;

import com.formdev.flatlaf.FlatLightLaf;
import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import src.data_access.APIAccessObject;
import src.entity.CreatePlayer;
import src.entity.CreatePlayerFactory;
import src.entity.Player;
import src.entity.PlayerFactory;
import src.interface_adapter.ViewManagerModel;
import src.interface_adapter.create_player.CreatePlayerViewModel;
import src.interface_adapter.game.GameViewModel;
import src.view.GameView;
import src.view.CreatePlayerView;
import src.view.ViewManager;
import src.data_access.FileDataAccessObject;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /*
    This is a basic example of a prompt with the ideas that we had implemented
    Need to figure out a way to add the required plot points, player stats, locations (and its information) in a CA Engine format

    String systemPrompt = """
                I want you to act as if you were a D&D dungeon master. Do not ever break out of character and you MUST not refer to yourself in any way.
                You are going to guide the player through a story with the following major plot points: [The Mysterious Artifact:Ancient artifact, factions, political intrigue. The Vanishing Town: Town disappears, parallel dimension, mysterious portal. The Dragon's Prophecy: Dragon's prophecy, ancient artifacts, calamity. The Cursed Kingdom: Kingdom cursed, twisted minds, moral dilemmas. The Celestial War: Celestial-infernal war, cosmic balance. The Forbidden Library: Mystical library, forbidden magics, sentient. The Time Rift: Temporal anomaly, traverse eras, restore balance.]. The player has currently finished [] plot points.
                The player is a level 1 warrior with the following stats, [HP: 13, AC: 16, Strength: 15, Dexterity: 13, Constitution: 16].  They have in their inventory [Sword: 2d4, 2 torches].
                There are the following locations: [Eldritch Citadel: Arcane fortress, shifting walls, wizards. Whispering Woods: Enchanted forest, fey creatures, portals. Forgepeak Mountains: Dwarven blacksmiths, dragon lairs, perilous. City of Eternal Shadows: Perpetual gloom, underworld haven, mysterious. Sky Isles: Floating islands, airships, rare resources.] They are currently in the [City of Eternal Shadows]
                User messages written in square brackets are commands.""";
     */

    /*
    public static void main(String[] args) {
        APIAccessObject api = new APIAccessObject();

        Scanner reader = new Scanner(System.in);

        List<String[]> history = new ArrayList<String[]>();
        while(true) {
            String systemPrompt = """
                    I want you to act as if you were a D&D dungeon master. Do not ever break out of character and you MUST not refer to yourself in any way.
                    You are going to guide the player through a story with the following major plot points: [The Mysterious Artifact:Ancient artifact, factions, political intrigue. The Vanishing Town: Town disappears, parallel dimension, mysterious portal. The Dragon's Prophecy: Dragon's prophecy, ancient artifacts, calamity. The Cursed Kingdom: Kingdom cursed, twisted minds, moral dilemmas. The Celestial War: Celestial-infernal war, cosmic balance. The Forbidden Library: Mystical library, forbidden magics, sentient. The Time Rift: Temporal anomaly, traverse eras, restore balance.]. The player has currently finished [] plot points.
                    The player is a level 1 warrior with the following stats, [HP: 13, AC: 16, Strength: 15, Dexterity: 13, Constitution: 16].  They have in their inventory [Sword: 2d4, 2 torches].
                    There are the following locations: [Eldritch Citadel: Arcane fortress, shifting walls, wizards. Whispering Woods: Enchanted forest, fey creatures, portals. Forgepeak Mountains: Dwarven blacksmiths, dragon lairs, perilous. City of Eternal Shadows: Perpetual gloom, underworld haven, mysterious. Sky Isles: Floating islands, airships, rare resources.] They are currently in the [City of Eternal Shadows]
                    User messages written in square brackets are commands. You must include ANSI codes for colouring of the text.""";

            api.addSystemPrompt(systemPrompt);

            api.addHistory(history);

            String userPrompt = reader.nextLine();

            api.addUserPrompt(userPrompt);

            // Print out results of the response
            List<ChatCompletionChoice> choices = api.runChatGPT();
            System.out.println(choices);

            history.add(new String[]{userPrompt, choices.get(0).getMessage().getContent()});
            api.clearMessages();
            history = history.subList(Math.max(history.size() - 3, 0), history.size());
        }
    }
    */

    public static void main(String[] args) throws IOException {
        FlatLightLaf.setup();

        JFrame application = new JFrame("Game");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        GameViewModel gameViewModel = new GameViewModel();

        APIAccessObject apiAccessObject = new APIAccessObject();

        GameView gameView = GameUseCaseFactory.create(viewManagerModel, gameViewModel, apiAccessObject);
        views.add(gameView, gameView.viewName);

        viewManagerModel.setActiveView(gameView.viewName);

        application.pack();
        application.setVisible(true);

        CreatePlayerViewModel createPlayerViewModel = new CreatePlayerViewModel();
        CreatePlayerView createPlayerView = CreatePlayerUseCaseFactory.create(viewManagerModel, createPlayerViewModel, apiAccessObject);
        views.add(createPlayerView, createPlayerView.viewName);
        viewManagerModel.setActiveView(createPlayerView.viewName);
        application.pack();
        application.setVisible(true);

        new FileDataAccessObject("./users.csv", (name, stats, xp, aClass, backstory) -> null);
    }
}
