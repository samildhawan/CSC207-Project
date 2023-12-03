/**
 * The TitleOutputData class stores the output data for the title screen use case.
 *
 * @author Maryann Chen
 * @author Samil Dhawan
 * @author Mohamed Ebsim
 * @since 17.0.8.1
 *
 */
package src.use_case.title;

public class TitleOutputData {

    private final String newScreen;

    /**
     * Constructor for TitleOutputData to store the target of the new screen.
     * @param newScreen         the target to switch screens to
     */
    public TitleOutputData(String newScreen) {
        this.newScreen = newScreen;
    }

    /**
     * Get the name of the view to switch to
     * @return newScreen        name of the new view
     */
    public String getNewScreen() { return this.newScreen; }

}
