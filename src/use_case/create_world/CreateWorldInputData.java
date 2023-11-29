package src.use_case.create_world;

import src.entity.Location;

import java.util.List;

public class CreateWorldInputData {

    final private List<Location> locations;

    public CreateWorldInputData(List<Location> locations) {
        this.locations = locations;
    }

    public List<Location> getLocations() {
        return locations;
    }
}
