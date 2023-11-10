package src.interface_adapter.game;

import src.use_case.game.GameInputBoundary;
import src.use_case.game.GameInputData;

public class GameController {

    final GameInputBoundary gameUseCaseInteractor;

    public GameController(GameInputBoundary gameUseCaseInteractor) {
        this.gameUseCaseInteractor = gameUseCaseInteractor;
    }

    public void execute(String prompt) {
        GameInputData gameInputData = new GameInputData(prompt);

        gameUseCaseInteractor.execute(gameInputData);
    }
}
