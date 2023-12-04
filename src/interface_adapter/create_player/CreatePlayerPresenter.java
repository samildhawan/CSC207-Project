package src.interface_adapter.create_player;

import src.interface_adapter.ViewManagerModel;
import src.use_case.create_player.CreatePlayerOutputBoundary;
import src.use_case.create_player.CreatePlayerOutputData;

public class CreatePlayerPresenter implements CreatePlayerOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final CreatePlayerViewModel createPlayerViewModel;

    public CreatePlayerPresenter(ViewManagerModel viewManagerModel,
                                 CreatePlayerViewModel createPlayerViewModel){
        this.viewManagerModel = viewManagerModel;
        this.createPlayerViewModel = createPlayerViewModel;
    }

    @Override
    public void prepareSuccessView(CreatePlayerOutputData data){
        CreatePlayerState currentState = createPlayerViewModel.getState();
        currentState.setHistory(currentState.getHistory() + "\n" + data.getMessage());
        createPlayerViewModel.firePropertyChanged();
        viewManagerModel.setActiveView("title");
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error){
        CreatePlayerState currentState = createPlayerViewModel.getState();
        currentState.setPromptError("Failed to save information. Please try again.");
        createPlayerViewModel.firePropertyChanged();
    }
}
