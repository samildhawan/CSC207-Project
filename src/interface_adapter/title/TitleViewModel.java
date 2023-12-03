/**
 * The TitleViewModel class provides a connection between the TitleState, the TitleView and the rest of the code.
 *
 * @author Maryann Chen
 * @author Samil Dhawan
 * @author Mohamed Ebsim
 * @since 17.0.8.1
 *
 */
package src.interface_adapter.title;

import src.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TitleViewModel extends ViewModel {

    private TitleState state = new TitleState();

    public TitleViewModel() { super("title"); }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * firePropertyChanged updates the state in all PropertyChangeListeners
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * addPropertyChangeListener adds a listener to which the support can update
     * @param listener          A listener to add to the
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * getState returns the current TitleState
     * @return state         the current TitleState
     */
    public TitleState getState() { return state; }
}
