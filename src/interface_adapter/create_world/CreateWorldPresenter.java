package src.interface_adapter.create_world;

import src.interface_adapter.ViewManagerModel;
import src.use_case.create_world.CreateWorldOutputBoundary;
import src.use_case.create_world.CreateWorldOutputData;

public class CreateWorldPresenter implements CreateWorldOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final CreateWorldViewModel createWorldViewModel;

    public CreateWorldPresenter(ViewManagerModel viewManagerModel,
                                CreateWorldViewModel createWorldViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.createWorldViewModel = createWorldViewModel;
    }

}
