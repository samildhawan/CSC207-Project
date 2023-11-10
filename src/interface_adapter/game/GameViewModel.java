package src.interface_adapter.game;

import src.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GameViewModel extends ViewModel {

    public static final String SUBMIT_BUTTON_LABEL = "Submit";

    private GameState state = new GameState();


    public GameViewModel() {
        super("game");
    }

    public void setState(GameState state) {this.state = state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public GameState getState() { return state; }
}
