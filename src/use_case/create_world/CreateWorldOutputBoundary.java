package src.use_case.create_world;

public interface CreateWorldOutputBoundary {
    void prepareSuccessView(CreateWorldOutputData data);

    void prepareFailView(String error);
}
