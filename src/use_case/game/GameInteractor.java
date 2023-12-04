package src.use_case.game;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import src.entity.Player;
import src.entity.WorldStory;

import java.util.List;

public class GameInteractor implements GameInputBoundary {

    final GameDataAccessInterface gameDataAccessObject;
    final GameOutputBoundary gamePresenter;

    public GameInteractor(GameDataAccessInterface gameDataAccessInterface, GameOutputBoundary gameOutputBoundary) {
        this.gameDataAccessObject = gameDataAccessInterface;
        this.gamePresenter = gameOutputBoundary;
    }

    @Override
    public void execute(GameInputData gameInputData) {
        System.out.println("WORKING ON THE PROMPT");
        try {
            WorldStory worldStory = gameDataAccessObject.getWorldStory();

            String systemPrompt = worldStory.getPrompt();

            Player currentPlayer = gameDataAccessObject.getPlayer();

            systemPrompt += "The player is named " + currentPlayer.getName() + ". Their background is as follows: " +
                    currentPlayer.getBackstory() + ". They are level " + currentPlayer.getLevel() + ". They are a " +
                    currentPlayer.getClassType();

            gameDataAccessObject.addSystemPrompt(systemPrompt);
            gameDataAccessObject.addHistory(worldStory.getHistory());
            gameDataAccessObject.addUserPrompt(gameInputData.getPrompt());
            // Print out results of the response
            List<ChatCompletionChoice> choices = gameDataAccessObject.runChatGPT();

            GameOutputData gameOutputData = new GameOutputData(choices);

            worldStory.addHistory(new String[]{gameInputData.getPrompt(), gameOutputData.getMessage()});

            gameDataAccessObject.clearMessages();

            gamePresenter.prepareSuccessView(gameOutputData);
        } catch(Exception e) {
            gamePresenter.prepareFailView("Failed to prompt");
        }
    }
}
