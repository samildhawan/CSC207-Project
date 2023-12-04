package src.interface_adapter.create_player;

import src.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Represents the ViewModel for creating a player, managing state changes and property listeners.
 */
public class CreatePlayerViewModel extends ViewModel {

    public static final String SUBMIT_BUTTON_LABEL = "Confirm your choice";
    private CreatePlayerState state = new CreatePlayerState();

    /**
     * Constructor for CreatePlayerViewModel.
     */
    public CreatePlayerViewModel() {
        super("create player");
    }

    /**
     * Sets the state of the CreatePlayerViewModel.
     *
     * @param state The state to set.
     */
    public void setState(CreatePlayerState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Fires property change event.
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a property change listener.
     *
     * @param listener The listener to add.
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Retrieves the current state of CreatePlayerViewModel.
     *
     * @return The current state.
     */
    public CreatePlayerState getState() {
        return state;
    }
}
