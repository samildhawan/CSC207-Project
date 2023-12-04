package src.view;

import src.interface_adapter.game.GameController;
import src.interface_adapter.game.GameState;
import src.interface_adapter.game.GameViewModel;

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

public class GameView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "game";

    private final JTextArea promptInputField = new JTextArea("Enter your prompt", 2, 50);
    private final JTextArea historyField = new JTextArea(10, 50);

    private final JButton submit;

    public GameView(GameController gameController, GameViewModel gameViewModel) {
        gameViewModel.addPropertyChangeListener(this);

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
        submit = new JButton(GameViewModel.SUBMIT_BUTTON_LABEL);
        buttons.add(submit);

        submit.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(submit)) {
                            GameState currentState = gameViewModel.getState();

                            gameController.execute(currentState.getPrompt());
                        }
                    }
                }
        );

        promptInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        GameState currentState = gameViewModel.getState();
                        String text = promptInputField.getText() + e.getKeyChar();
                        currentState.setPrompt(text);
                        gameViewModel.setState(currentState);
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
                        GameState currentState = gameViewModel.getState();
                        String text = historyField.getText() + e.getKeyChar();
                        currentState.setHistory(text);
                        gameViewModel.setState(currentState);
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
        GameState state = (GameState) evt.getNewValue();
        if (state.getPromptError() != null) {
            JOptionPane.showMessageDialog(this, state.getPromptError());
        }
        historyField.setText(state.getHistory());
        promptInputField.setText("");
    }
}
