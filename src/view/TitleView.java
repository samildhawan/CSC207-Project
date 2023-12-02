/**
 * The TitleView class represents the view that the user sees first and links it to the other views to create the player
 * and to start playing the game
 *
 * @author Maryann Chen
 * @author Samil Dhawan
 * @author Mohamed Ebsim
 * @since 17.0.8.1
 *
 */
package src.view;

import src.interface_adapter.title.TitleController;
import src.interface_adapter.title.TitleViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TitleView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "title";
    private final TitleViewModel titleViewModel;
    private final TitleController titleController;

    private final JButton start;
    private final JButton createPlayer;
    private final JButton createWorld;

    /**
     * Constructs a new TitleView with the specified TitleController and TitleViewModel
     *
     * @param titleController      The controller for the title screen.
     * @param titleViewModel       The view model for the title screen.
     */
    public TitleView(TitleController titleController, TitleViewModel titleViewModel) {
        this.titleController = titleController;
        this.titleViewModel = titleViewModel;

        titleViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("SCRIPT WRITER");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        start = new JButton("START GAME");
        createPlayer = new JButton("CREATE A PLAYER");
        createWorld = new JButton("CREATE A WORLD");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
