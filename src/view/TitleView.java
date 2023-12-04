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
import src.interface_adapter.title.TitleState;
import src.interface_adapter.title.TitleViewModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TitleView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "title";

    private final JButton start;
    private final JButton createPlayer;

    /**
     * Constructs a new TitleView with the specified TitleController and TitleViewModel
     *
     * @param titleController      The controller for the title screen.
     * @param titleViewModel       The view model for the title screen.
     */
    public TitleView(TitleController titleController, TitleViewModel titleViewModel) {

        titleViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("QUEST WEAVER");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.setBorder(new EmptyBorder(50, 10, 10, 10));

        JPanel buttons = new JPanel();
        start = new JButton("    START GAME    ");
        createPlayer = new JButton("CREATE A PLAYER");

        buttons.add(start);
        buttons.add(createPlayer);

        start.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(start)) {
                            titleController.execute("game");
                        }
                    }
                }
        );

        createPlayer.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(createPlayer)) {
                            titleController.execute("create player");
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        buttons.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        buttons.setBorder(new EmptyBorder(50, 10, 50, 10));
        this.add(buttons);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        TitleState state = (TitleState) evt.getNewValue();
        if(state.getFail()) {
            JOptionPane.showMessageDialog(this, "Error");
        }
        state.setFail(false);
    }
}
