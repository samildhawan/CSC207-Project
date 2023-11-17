package src.interface_adapter.game;

import src.interface_adapter.ViewManagerModel;
import src.use_case.game.GameOutputBoundary;
import src.use_case.game.GameOutputData;

public class GamePresenter implements GameOutputBoundary {

    private final ViewManagerModel viewManagerModel;
    private final GameViewModel gameViewModel;

    public GamePresenter(ViewManagerModel viewManagerModel, GameViewModel gameViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.gameViewModel = gameViewModel;
    }

    @Override
    public void prepareSuccessView(GameOutputData data) {
        GameState currentState = gameViewModel.getState();
        currentState.setHistory(currentState.getHistory() + data.getMessage() + "\n");
        gameViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        GameState currentState = gameViewModel.getState();
        currentState.setPromptError("Failed to generate text.");
        gameViewModel.firePropertyChanged();
    }
}
