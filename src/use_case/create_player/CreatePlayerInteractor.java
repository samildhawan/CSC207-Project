package src.use_case.create_player;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;

import java.util.List;
/**
 * Interactor responsible for creating a player based on user input data.
 */
public class CreatePlayerInteractor implements CreatePlayerInputBoundary {

    private final CreatePlayerDataAccessInterface createPlayerDataAccessObject;
    private final CreatePlayerOutputBoundary createPlayerPresenter;

    /**
     * Constructs a CreatePlayerInteractor.
     *
     * @param createPlayerDataAccessInterface The data access interface for creating a player.
     * @param createPlayerOutputBoundary     The output boundary for presenting created player data.
     */
    public CreatePlayerInteractor(CreatePlayerDataAccessInterface createPlayerDataAccessInterface,
                                  CreatePlayerOutputBoundary createPlayerOutputBoundary) {
        this.createPlayerDataAccessObject = createPlayerDataAccessInterface;
        this.createPlayerPresenter = createPlayerOutputBoundary;
    }

    /**
     * Executes the creation of a player based on the input data.
     *
     * @param createPlayerInputData The input data required to create a player.
     */

    @Override
    public void execute(CreatePlayerInputData createPlayerInputData) {
        System.out.println("WORKING ON YOUR CHARACTER PROMPT");
        try {
            String systemPrompt = """
                    I want you to act as if you were a D&D dungeon master. Do not ever break out of character and you
                    MUST not refer to yourself in any way. You are going to give the player the backstory of the Warrior class,\s
                    including its own unique name. Be creative, as the backstory should include where the class is from from this list of locations:
                    [The Vanishing Town, The Cursed Kingdom, The Forbidden Library, Eldritch Citadel, Sky Isles]. This should be random each time.\s
                    Also mention the character's political affiliation, and let the player know its current stats: [HP: 13, AC: 16, Strength: 15, Dexterity: 13, Constitution: 16].
                    User messages written in square brackets are commands. You must include ANSI codes for colouring of the text.""";
            createPlayerDataAccessObject.addSystemPrompt(systemPrompt);
            createPlayerDataAccessObject.addUserPrompt(createPlayerInputData.getPrompt());
            List<ChatCompletionChoice> choices = createPlayerDataAccessObject.runChatGPT();
            CreatePlayerOutputData createPlayerOutputData = new CreatePlayerOutputData(choices);
            createPlayerDataAccessObject.clearMessages();

            createPlayerPresenter.prepareSuccessView(createPlayerOutputData);
        } catch (Exception e) {
            createPlayerPresenter.prepareFailView("Failed to prompt");
        }

    }
}
