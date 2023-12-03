package src.app;

import src.interface_adapter.ViewManagerModel;
import src.interface_adapter.create_player.CreatePlayerController;
import src.interface_adapter.create_player.CreatePlayerPresenter;
import src.interface_adapter.create_player.CreatePlayerViewModel;
import src.use_case.create_player.CreatePlayerDataAccessInterface;
import src.use_case.create_player.CreatePlayerInputBoundary;
import src.use_case.create_player.CreatePlayerInteractor;
import src.use_case.create_player.CreatePlayerOutputBoundary;
import src.view.CreatePlayerView;

public class CreatePlayerUseCaseFactory {

    private CreatePlayerUseCaseFactory(){}

    public static CreatePlayerView create(ViewManagerModel viewManagerModel, CreatePlayerViewModel createPlayerViewModel, CreatePlayerDataAccessInterface createPlayerDataAccessInterface){
        CreatePlayerController createPlayerController = createPlayerUseCase(viewManagerModel, createPlayerViewModel, createPlayerDataAccessInterface);
        return new CreatePlayerView(createPlayerController, createPlayerViewModel);
    }

    private static CreatePlayerController createPlayerUseCase(ViewManagerModel viewManagerModel, CreatePlayerViewModel createPlayerViewModel, CreatePlayerDataAccessInterface createPlayerDataAccessInterface){
        CreatePlayerOutputBoundary createPlayerOutputBoundary = new CreatePlayerPresenter(viewManagerModel, createPlayerViewModel);
        CreatePlayerInputBoundary createPlayerInteractor = new CreatePlayerInteractor(createPlayerDataAccessInterface, createPlayerOutputBoundary);
        return new CreatePlayerController(createPlayerInteractor);
    }
}
