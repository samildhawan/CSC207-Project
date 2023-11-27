package src.use_case.create_player;

public interface CreatePlayerOutputBoundary {

    void prepareSuccessView(CreatePlayerOutputData data);
    void prepareFailView(String error);
}
