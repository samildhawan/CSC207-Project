package src.view;

import src.interface_adapter.game.GameController;
import src.interface_adapter.game.GameState;
import src.interface_adapter.game.GameViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GameView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "game";
    private final GameViewModel gameViewModel;
    private final GameController gameController;

    private final JTextArea promptInputField = new JTextArea(5, 15);
    private final JTextArea historyField = new JTextArea(5, 15);

    private final JButton submit;

    public GameView(GameController gameController, GameViewModel gameViewModel) {
        this.gameController = gameController;
        this.gameViewModel = gameViewModel;
        gameViewModel.addPropertyChangeListener(this);

        historyField.setLineWrap(true);
        promptInputField.setLineWrap(true);

        // Create the layout
        JLabel title = new JLabel("GAME SCREEN");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

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

        this.add(title);
        this.add(historyField);
        this.add(promptInputField);
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
