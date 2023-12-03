/**
 * The CreateWorldInteractor class is responsible for handling the creation of a game world.
 * It implements the CreateWorldInputBoundary interface to define the input boundary for creating a world.
 *
 * @author Maryann Chen
 * @author Samil Dhawan
 * @author Mohamed Ebsim
 * @since 17.0.8.1
 *
 */

package src.use_case.create_world;

import src.entity.Location;

import java.util.List;

public class CreateWorldInteractor implements CreateWorldInputBoundary{

    /**
     * The presenter for displaying the created world.
     */

    final CreateWorldOutputBoundary worldPresenter;

    /**
     * The data access object for interacting with the game world data.
     */

    final CreateWorldDataAccessInterface worldDataAccessObject;

    /**
     * Constructs a new CreateWorldInteractor.
     *
     * @param worldDataAccessInterface The data access interface for interacting with the game world data.
     * @param worldOutputBoundary      The output boundary for presenting the created world.
     */

    public CreateWorldInteractor(CreateWorldDataAccessInterface worldDataAccessInterface, CreateWorldOutputBoundary worldOutputBoundary) {
        this.worldDataAccessObject = worldDataAccessInterface;
        this.worldPresenter = worldOutputBoundary;
    }

    /**
     * Executes the process of creating a game world based on the provided input data.
     *
     * @param createWorldInputData The input data containing information needed to create the world.
     */
    @Override
    public void execute(CreateWorldInputData createWorldInputData) {
        List<Location> locations = createWorldInputData.getLocations();
    }
}
