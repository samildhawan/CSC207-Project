package src.interface_adapter.create_player;

import src.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreatePlayerViewModel extends ViewModel {

    private CreatePlayerState state = new CreatePlayerState();


    public CreatePlayerViewModel() {
        super("Create Player");
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
