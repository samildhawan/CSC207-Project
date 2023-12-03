/**
 * The TitlePresenter class is the OutputBoundary for title screen which prepares the success and fail views.
 * Specifically it switches the views using the ViewManagerModel.
 *
 * @author Maryann Chen
 * @author Samil Dhawan
 * @author Mohamed Ebsim
 * @since 17.0.8.1
 *
 */package src.interface_adapter.title;

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

    /**
     * Constructor for TitlePresenter.
     *
     * @param titleViewModel
     * @param gameViewModel
     * @param viewManagerModel
     * @param createPlayerViewModel
     */
    public TitlePresenter(TitleViewModel titleViewModel, GameViewModel gameViewModel, ViewManagerModel viewManagerModel, CreatePlayerViewModel createPlayerViewModel) {
        this.titleViewModel = titleViewModel;
        this.gameViewModel = gameViewModel;
        this.createPlayerViewModel = createPlayerViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * prepareSuccessView takes in a TitleOutputData and switches views using the ViewManagerModel
     * @param response
     */
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

    /**
     * prepareFailView returns an error in the case it could not switch screens
     */
    @Override
    public void prepareFailView() {
        TitleState titleState = titleViewModel.getState();
        titleState.setFail(true);
        titleViewModel.firePropertyChanged();
    }
}
