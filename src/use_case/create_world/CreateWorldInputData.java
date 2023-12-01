/**
 * The CreateWorldInputData class represents the input data required for creating a game world.
 * It contains a list of locations that define the initial state of the game world.
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

public class CreateWorldInputData {
    /**
     * The list of locations defining the initial state of the game world.
     */
    final private List<Location> locations;

    /**
     * Constructs a new CreateWorldInputData object with the specified list of locations.
     *
     * @param locations The list of locations defining the initial state of the game world.
     */
    public CreateWorldInputData(List<Location> locations) {
        this.locations = locations;
    }

    /**
     * Gets the list of locations from the input data.
     *
     * @return The list of locations defining the initial state of the game world.
     */
    public List<Location> getLocations() {
        return locations;
    }
}
