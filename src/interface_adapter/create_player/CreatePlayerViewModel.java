package src.interface_adapter.create_player;

import src.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreatePlayerViewModel extends ViewModel {

    public static final String SUBMIT_BUTTON_LABEL = "Confirm your choice";
    private CreatePlayerState state = new CreatePlayerState();


    public CreatePlayerViewModel() {
        super("create player");
    }

    public void setState(CreatePlayerState state) {this.state = state;}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public CreatePlayerState getState() { return state; }
}
