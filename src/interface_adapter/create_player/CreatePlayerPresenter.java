package src.interface_adapter.create_player;

import src.interface_adapter.ViewManagerModel;
import src.use_case.create_player.CreatePlayerOutputBoundary;

public class CreatePlayerPresenter implements CreatePlayerOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final CreatePlayerViewModel createPlayerViewModel;

    public CreatePlayerPresenter(ViewManagerModel viewManagerModel,
                                 CreatePlayerViewModel createPlayerViewModel){
        this.viewManagerModel = viewManagerModel;
        this.createPlayerViewModel = createPlayerViewModel;
    }
}
