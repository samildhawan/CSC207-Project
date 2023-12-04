package src.interface_adapter.create_player;

import src.use_case.create_player.CreatePlayerInputBoundary;
import src.use_case.create_player.CreatePlayerInputData;

/**
 * Controller responsible for executing the CreatePlayer functionality based on user input.
 */
public class CreatePlayerController {

    private final CreatePlayerInputBoundary createPlayerUseCaseInteractor;

    /**
     * Constructs a CreatePlayerController.
     *
     * @param createPlayerUseCaseInteractor The input boundary for the CreatePlayer use case.
     */
    public CreatePlayerController(CreatePlayerInputBoundary createPlayerUseCaseInteractor){
        this.createPlayerUseCaseInteractor = createPlayerUseCaseInteractor;
    }

    /**
     * Executes the CreatePlayer use case with the provided input.
     *
     * @param prompt The prompt for creating a player.
     */
    public void execute(String prompt){
        CreatePlayerInputData createPlayerInputData = new CreatePlayerInputData(prompt);

        createPlayerUseCaseInteractor.execute(createPlayerInputData);
    }
}
