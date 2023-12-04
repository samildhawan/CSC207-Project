package src.use_case.create_player;

/**
 * Interface representing the output boundary for creating a player.
 * It defines methods to prepare views for success and failure scenarios.
 */
public interface CreatePlayerOutputBoundary {

    /**
     * Prepares the success view based on the provided data.
     *
     * @param data The output data for a successful player creation.
     */
    void prepareSuccessView(CreatePlayerOutputData data);

    /**
     * Prepares the failure view based on the given error message.
     *
     * @param error The error message indicating the reason for failure.
     */
    void prepareFailView(String error);
}
