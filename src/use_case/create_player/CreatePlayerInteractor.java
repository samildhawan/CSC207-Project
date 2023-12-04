package src.use_case.create_player;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;

import java.util.List;

public class CreatePlayerInteractor implements CreatePlayerInputBoundary {

    final CreatePlayerDataAccessInterface createPlayerDataAccessObject;

    final CreatePlayerOutputBoundary createPlayerPresenter;

    public CreatePlayerInteractor(CreatePlayerDataAccessInterface createPlayerDataAccessInterface,
                                  CreatePlayerOutputBoundary createPlayerOutputBoundary) {

        this.createPlayerDataAccessObject = createPlayerDataAccessInterface;
        this.createPlayerPresenter = createPlayerOutputBoundary;
    }

    @Override
    public void execute(CreatePlayerInputData createPlayerInputData) {
        try {
            String systemPrompt = """
                    I want you to act as if you were a program that assists D&D dungeon masters in generating narratives. Do not ever break out of character and you
                    MUST not refer to yourself in any way. You are going to give the player the backstory of the Warrior class.
                    Be creative, as the backstory should include where the class is from from this list of locations:
                    [The Vanishing Town, The Cursed Kingdom, The Forbidden Library, Eldritch Citadel, Sky Isles]. This should be random each time.\s
                    Also mention the character's political affiliation, and let the player know its current stats: [HP: 13, AC: 16, Strength: 15, Dexterity: 13, Constitution: 16].
                    You must keep the backstory to less than three sentences. The user will input their name.""";
            createPlayerDataAccessObject.addSystemPrompt(systemPrompt);
            createPlayerDataAccessObject.addUserPrompt(createPlayerInputData.getPrompt());
            List<ChatCompletionChoice> choices = createPlayerDataAccessObject.runChatGPT();
            CreatePlayerOutputData createPlayerOutputData = new CreatePlayerOutputData(choices);
            createPlayerDataAccessObject.clearMessages();

            createPlayerDataAccessObject.save(createPlayerInputData.getPrompt(), createPlayerOutputData.getMessage());

            createPlayerPresenter.prepareSuccessView(createPlayerOutputData);
        } catch (Exception e) {
            createPlayerPresenter.prepareFailView("Failed to prompt");
        }

    }
}
