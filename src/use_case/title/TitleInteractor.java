package src.use_case.title;

public class TitleInteractor implements TitleInputBoundary {

    final TitleOutputBoundary titlePresenter;

    public TitleInteractor(TitleOutputBoundary titleOutputBoundary) {
        this.titlePresenter = titleOutputBoundary;
    }

    @Override
    public void execute(String newView) {
        if(newView.equals("game")) {
            // Ensure that the character and player is loaded.
            TitleOutputData outputData = new TitleOutputData(newView);
            titlePresenter.prepareSuccessView(outputData);

            // If not loaded, fail
        } else if (newView.equals("create player")) {
            System.out.println(newView);
            TitleOutputData outputData = new TitleOutputData(newView);
            titlePresenter.prepareSuccessView(outputData);
        } else {
            titlePresenter.prepareFailView();
        }
    }
}
