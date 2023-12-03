/**
 * The TitleController class processes the requests from the title screen.
 *
 * @author Maryann Chen
 * @author Samil Dhawan
 * @author Mohamed Ebsim
 * @since 17.0.8.1
 *
 */
package src.interface_adapter.title;

import src.use_case.title.TitleInputBoundary;

public class TitleController {

    final TitleInputBoundary titleInputBoundary;

    /**
     * Constructor for the TitleController
     * @param titleInputBoundary
     */
    public TitleController(TitleInputBoundary titleInputBoundary) {
        this.titleInputBoundary = titleInputBoundary;
    }

    /**
     * execute excutes the request from the title screen to change views.
     * @param newView         the view to switch to
     */
    public void execute(String newView) {
        titleInputBoundary.execute(newView);
    }
}
