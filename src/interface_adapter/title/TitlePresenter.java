package src.interface_adapter.title;

import src.interface_adapter.ViewManagerModel;
import src.interface_adapter.create_player.CreatePlayerViewModel;
import src.interface_adapter.game.GameViewModel;
import src.use_case.title.TitleOutputBoundary;
import src.use_case.title.TitleOutputData;

public class TitlePresenter implements TitleOutputBoundary {

    private final TitleViewModel titleViewModel;
    private final GameViewModel gameViewModel;
    private final CreatePlayerViewModel createPlayerViewModel;
    private ViewManagerModel viewManagerModel;

    public TitlePresenter(TitleViewModel titleViewModel, GameViewModel gameViewModel, ViewManagerModel viewManagerModel, CreatePlayerViewModel createPlayerViewModel) {
        this.titleViewModel = titleViewModel;
        this.gameViewModel = gameViewModel;
        this.createPlayerViewModel = createPlayerViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(TitleOutputData response) {
        // On success, switch to whichever screen chosen
        if (response.getNewScreen().equals("game")) {
            viewManagerModel.setActiveView(gameViewModel.getViewName());
        } else {
            viewManagerModel.setActiveView(createPlayerViewModel.getViewName());
        }
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView() {
        TitleState titleState = titleViewModel.getState();
        titleState.setFail(true);
        titleViewModel.firePropertyChanged();
    }
}
