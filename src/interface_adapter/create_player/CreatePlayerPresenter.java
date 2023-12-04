package src.interface_adapter.create_player;

import src.interface_adapter.ViewManagerModel;
import src.use_case.create_player.CreatePlayerOutputBoundary;
import src.use_case.create_player.CreatePlayerOutputData;

/**
 * Presenter responsible for handling outputs related to creating a player.
 */
public class CreatePlayerPresenter implements CreatePlayerOutputBoundary {

    private final ViewManagerModel viewManagerModel;
    private final CreatePlayerViewModel createPlayerViewModel;

    /**
     * Constructs a CreatePlayerPresenter.
     *
     * @param viewManagerModel     The view manager model.
     * @param createPlayerViewModel The view model for CreatePlayer.
     */
    public CreatePlayerPresenter(ViewManagerModel viewManagerModel,
                                 CreatePlayerViewModel createPlayerViewModel){
        this.viewManagerModel = viewManagerModel;
        this.createPlayerViewModel = createPlayerViewModel;
    }

    /**
     * Prepares the success view based on the output data from CreatePlayer.
     *
     * @param data The output data after a successful CreatePlayer operation.
     */
    @Override
    public void prepareSuccessView(CreatePlayerOutputData data){
        CreatePlayerState currentState = createPlayerViewModel.getState();
        currentState.setHistory(currentState.getHistory() + "\n" + data.getMessage());
        createPlayerViewModel.firePropertyChanged();
    }

    /**
     * Prepares the failure view with an error message.
     *
     * @param error The error message to display on a failed CreatePlayer operation.
     */
    @Override
    public void prepareFailView(String error){
        CreatePlayerState currentState = createPlayerViewModel.getState();
        currentState.setPromptError("Failed to save information. Please try again.");
        createPlayerViewModel.firePropertyChanged();
    }
}
