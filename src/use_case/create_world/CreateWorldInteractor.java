package src.use_case.create_world;

import src.use_case.game.GameDataAccessInterface;
import src.use_case.game.GameOutputBoundary;

public class CreateWorldInteractor implements CreateWorldInputBoundary{
    final CreateWorldDataAccessInterface worldDataAccessObject;
    final CreateWorldOutputBoundary worldPresenter;

    public CreateWorldInteractor(CreateWorldDataAccessInterface worldDataAccessInterface, CreateWorldOutputBoundary worldOutputBoundary) {
        this.worldDataAccessObject = worldDataAccessInterface;
        this.worldPresenter = worldOutputBoundary;
    }


    @Override
    public void execute(CreateWorldInputData createWorldInputData) {

    }
}
