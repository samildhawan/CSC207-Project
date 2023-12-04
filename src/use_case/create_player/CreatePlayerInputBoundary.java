package src.use_case.create_player;

/**
 * Interface defining the input boundary for creating a player.
 */
public interface CreatePlayerInputBoundary {

    /**
     * Executes the use case to create a player based on the provided input data.
     *
     * @param createPlayerInputData The input data needed to create a player.
     */
    void execute(CreatePlayerInputData createPlayerInputData);
}
