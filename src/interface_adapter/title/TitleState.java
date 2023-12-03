/**
 * The TitleState class contains data for the title screen.
 *
 * @author Maryann Chen
 * @author Samil Dhawan
 * @author Mohamed Ebsim
 * @since 17.0.8.1
 *
 */
package src.interface_adapter.title;

public class TitleState {

    private boolean fail = false;

    /**
     * getFail returns the fail status of the attempt to switch screens.
     * @return fail
     */
    public boolean getFail() { return fail; }

    /**
     * setFail sets the fail status of the title screen's attempt to switch screens.
     * @param fail
     */
    public void setFail(boolean fail) { this.fail = fail; }
}
