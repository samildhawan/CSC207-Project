package src.app;

import src.interface_adapter.ViewManagerModel;
import src.interface_adapter.create_player.CreatePlayerViewModel;
import src.interface_adapter.game.GameViewModel;
import src.interface_adapter.title.TitleController;
import src.interface_adapter.title.TitlePresenter;
import src.interface_adapter.title.TitleViewModel;
import src.use_case.title.TitleInputBoundary;
import src.use_case.title.TitleInteractor;
import src.use_case.title.TitleOutputBoundary;
import src.view.TitleView;

public class TitleUseCaseFactory {

    private TitleUseCaseFactory() {}

    public static TitleView create(TitleViewModel titleViewModel, ViewManagerModel viewManagerModel, GameViewModel gameViewModel, CreatePlayerViewModel createPlayerViewModel) {
        TitleController titleController = createTitleUseCase(titleViewModel, viewManagerModel, gameViewModel, createPlayerViewModel);

        return new TitleView(titleController, titleViewModel);
    }

    private static TitleController createTitleUseCase(TitleViewModel titleViewModel, ViewManagerModel viewManagerModel, GameViewModel gameViewModel, CreatePlayerViewModel createPlayerViewModel) {
        TitleOutputBoundary titleOutputBoundary = new TitlePresenter(titleViewModel, gameViewModel, viewManagerModel, createPlayerViewModel);

        TitleInputBoundary titleInteractor = new TitleInteractor(titleOutputBoundary);

        return new TitleController(titleInteractor);
    }
}
