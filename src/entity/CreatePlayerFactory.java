package src.entity;

import src.interface_adapter.ViewManagerModel;
import src.interface_adapter.create_player.CreatePlayerController;
import src.interface_adapter.create_player.CreatePlayerPresenter;
import src.interface_adapter.create_player.CreatePlayerViewModel;
import src.use_case.create_player.CreatePlayerDataAccessInterface;
import src.use_case.create_player.CreatePlayerInputBoundary;
import src.use_case.create_player.CreatePlayerInteractor;
import src.use_case.create_player.CreatePlayerOutputBoundary;
import src.view.CreatePlayerView;

public class CreatePlayerFactory implements PlayerFactory{

    @Override
    public Player create(String name, String stats, String xp, String aClass, String backstory) {
        return null;
    }
}
