package src.interface_adapter.title;

import src.interface_adapter.ViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TitleViewModel extends ViewModel {

    private TitleState state = new TitleState();

    public TitleViewModel() { super("title"); }

    public void setState(TitleState state) {this.state = state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public TitleState getState() { return state; }
}
