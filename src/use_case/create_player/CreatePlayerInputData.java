package src.use_case.create_player;

/**
 * Represents the input data required for creating a player.
 */
public class CreatePlayerInputData {

    private final String prompt;

    /**
     * Constructs CreatePlayerInputData with the provided prompt.
     *
     * @param prompt The prompt used to create a player.
     */
    public CreatePlayerInputData(String prompt){
        this.prompt = prompt;
    }

    /**
     * Retrieves the prompt used to create a player.
     *
     * @return The prompt.
     */
    public String getPrompt() {
        return prompt;
    }
}
