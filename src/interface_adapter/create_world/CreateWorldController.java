package src.interface_adapter.create_world;

import src.entity.Location;
import src.use_case.create_world.CreateWorldInputBoundary;
import src.use_case.create_world.CreateWorldInputData;

import java.util.List;

public class CreateWorldController {

    final CreateWorldInputBoundary createWorldUseCaseInteractor;

    public CreateWorldController(CreateWorldInputBoundary createWorldUseCaseInteractor){
        this.createWorldUseCaseInteractor = createWorldUseCaseInteractor;
    }

    public void execute(List<Location> locations){
        CreateWorldInputData createWorldInputData = new CreateWorldInputData(locations);
        createWorldUseCaseInteractor.execute(createWorldInputData);
    }
}
