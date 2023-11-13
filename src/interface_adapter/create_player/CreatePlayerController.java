package src.interface_adapter.create_player;

import src.use_case.create_player.CreatePlayerInputBoundary;
import src.use_case.create_player.CreatePlayerInputData;

public class CreatePlayerController {

    final CreatePlayerInputBoundary createPlayerUseCaseInteractor;

    public CreatePlayerController(CreatePlayerInputBoundary createPlayerUseCaseInteractor){
        this.createPlayerUseCaseInteractor = createPlayerUseCaseInteractor;
    }

    public void execute(String prompt){
        CreatePlayerInputData createPlayerInputData = new CreatePlayerInputData(prompt);

        createPlayerUseCaseInteractor.execute(createPlayerInputData);
    }
}
