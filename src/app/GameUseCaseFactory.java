package src.app;

import src.interface_adapter.ViewManagerModel;
import src.interface_adapter.game.GameController;
import src.interface_adapter.game.GamePresenter;
import src.interface_adapter.game.GameViewModel;
import src.use_case.game.GameDataAccessInterface;
import src.use_case.game.GameInputBoundary;
import src.use_case.game.GameInteractor;
import src.use_case.game.GameOutputBoundary;
import src.view.GameView;

public class GameUseCaseFactory {

    private GameUseCaseFactory() {}

    public static GameView create(ViewManagerModel viewManagerModel, GameViewModel gameViewModel, GameDataAccessInterface gameDataAccessObject) {
        GameController gameController = createGameUseCase(viewManagerModel, gameViewModel, gameDataAccessObject);

        return new GameView(gameController, gameViewModel);
    }

    private static GameController createGameUseCase(ViewManagerModel viewManagerModel, GameViewModel gameViewModel, GameDataAccessInterface gameDataAccessObject) {
        GameOutputBoundary gameOutputBoundary = new GamePresenter(viewManagerModel, gameViewModel);

        GameInputBoundary gameInteractor = new GameInteractor(gameDataAccessObject, gameOutputBoundary);

        return new GameController(gameInteractor);
    }
}
