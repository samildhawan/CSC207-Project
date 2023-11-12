package src.use_case.game;

public interface GameOutputBoundary {

    void prepareSuccessView(GameOutputData data);

    void prepareFailView(String error);

}
