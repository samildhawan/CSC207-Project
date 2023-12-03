/**
 * The TitleInteractor class is the use case interactor for the title screen use case.
 *
 * @author Maryann Chen
 * @author Samil Dhawan
 * @author Mohamed Ebsim
 * @since 17.0.8.1
 *
 */
package src.use_case.title;

public class TitleInteractor implements TitleInputBoundary {

    final TitleOutputBoundary titlePresenter;

    public TitleInteractor(TitleOutputBoundary titleOutputBoundary) {
        this.titlePresenter = titleOutputBoundary;
    }

    /**
     * execute determines which new view to switch to and does the necessary work prior to it to prepare it.
     * @param newView
     */
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
