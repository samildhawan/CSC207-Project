package src.view;

import src.interface_adapter.create_player.CreatePlayerController;
import src.interface_adapter.create_player.CreatePlayerState;
import src.interface_adapter.create_player.CreatePlayerViewModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultStyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CreatePlayerView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "create player";
    private final CreatePlayerViewModel createPlayerViewModel;
    private final CreatePlayerController createPlayerController;

    private final JTextArea promptInputField = new JTextArea("Here is your character: ", 2, 50);
    private final JTextArea historyField = new JTextArea(10, 50);

    private final JButton submit;

    public CreatePlayerView(CreatePlayerController createPlayerController, CreatePlayerViewModel createPlayerViewModel){
        this.createPlayerController = createPlayerController;
        this.createPlayerViewModel = createPlayerViewModel;
        createPlayerViewModel.addPropertyChangeListener(this);

        this.setBorder(new EmptyBorder(10, 10, 10, 10));

        historyField.setWrapStyleWord(true);
        historyField.setLineWrap(true);
        historyField.setEditable(false);
        promptInputField.setLineWrap(true);
        promptInputField.setWrapStyleWord(true);
        promptInputField.putClientProperty( "JComponent.roundRect", true );

        JScrollPane scrollPane = new JScrollPane(historyField);

        // Create the layout
        JPanel buttons = new JPanel();
        submit = new JButton(CreatePlayerViewModel.SUBMIT_BUTTON_LABEL);
        buttons.add(submit);

        submit.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(submit)) {
                            CreatePlayerState currentState = createPlayerViewModel.getState();

                            createPlayerController.execute(currentState.getPrompt());
                        }
                    }
                }
        );

        promptInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CreatePlayerState currentState = createPlayerViewModel.getState();
                        String text = promptInputField.getText() + e.getKeyChar();
                        currentState.setPrompt(text);
                        createPlayerViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {}

                    @Override
                    public void keyReleased(KeyEvent e) {}
                }
        );

        historyField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CreatePlayerState currentState = createPlayerViewModel.getState();
                        String text = historyField.getText() + e.getKeyChar();
                        currentState.setHistory(text);
                        createPlayerViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {}

                    @Override
                    public void keyReleased(KeyEvent e) {}
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(scrollPane);
        this.add(promptInputField, BorderLayout.SOUTH);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        CreatePlayerState state = (CreatePlayerState) evt.getNewValue();
        if (state.getPromptError() != null) {
            JOptionPane.showMessageDialog(this, state.getPromptError());
        }
        historyField.setText(state.getHistory());
        promptInputField.setText("");
    }

}
