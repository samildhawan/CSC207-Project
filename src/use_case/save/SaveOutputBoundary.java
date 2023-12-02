package src.use_case.save;

public interface SaveOutputBoundary {
    void prepareSuccessView(SaveOutputData data);

    void prepareFailView(String error);

}
