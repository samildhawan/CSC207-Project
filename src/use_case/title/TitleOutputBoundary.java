package src.use_case.title;

public interface TitleOutputBoundary {

    void prepareSuccessView(TitleOutputData response);

    void prepareFailView();
}