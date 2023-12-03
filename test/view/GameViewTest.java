package test.view;

import src.app.Main;
import src.view.GameView;
import src.view.TitleView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;

public class GameViewTest {

    // Make view
    // Check that we can type text into prompt
    // Check that we cannot type text into history
    // Check that clicking submit causes
    // Check

    private GameView getGameView() {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        assertNotNull(app); // found the window?

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        return (GameView) jp2.getComponent(0);
    }

    private JButton getButton() {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        assertNotNull(app); // found the window?

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        GameView sv = (GameView) jp2.getComponent(0);

        JPanel buttons = (JPanel) sv.getComponent(2);

        return (JButton) buttons.getComponent(0); // this should be the submit button
    }

    private JScrollPane getHistoryTextArea() {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        assertNotNull(app); // found the window?

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        GameView sv = (GameView) jp2.getComponent(0);

        return (JScrollPane) sv.getComponent(0);
    }

    private JTextArea getPromptTextArea() {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        assertNotNull(app); // found the window?

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        GameView sv = (GameView) jp2.getComponent(0);

        return (JTextArea) sv.getComponent(1);
    }

    private void switchToGameView() {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        TitleView titleView = (TitleView) jp2.getComponent(2);

        JPanel buttons = (JPanel) titleView.getComponent(1);

        ((JButton) buttons.getComponent(0)).doClick();
    }

    @org.junit.Test
    public void testSubmitButtonPresent() {
        Main.main(null);
        JButton button = getButton();
        assert(button.getText().equals("Submit"));
    }

    @org.junit.Test
    public void testSubmitFunction() {
        Main.main(null);
        JScrollPane history = getHistoryTextArea();
        JTextArea historyTextArea = (JTextArea) history.getViewport().getView();
        JTextArea promptTextArea = getPromptTextArea();
        GameView gameView = getGameView();

        assert(!historyTextArea.isEditable());
        assert(historyTextArea.getText().isEmpty());
        assert(promptTextArea.isEditable());
        assert(!promptTextArea.getText().isEmpty());

        switchToGameView();

        // Hi is 72, 72
        try {
            // Empty textbox
            promptTextArea.setText("");
            promptTextArea.grabFocus();
            System.out.println(promptTextArea.getText());

            Robot rob = new Robot();

            rob.keyPress(KeyEvent.VK_H);
            TimeUnit.SECONDS.sleep(1);
            // For every button press, I should also check GameState to see if it updated too
            rob.keyRelease(KeyEvent.VK_H);

            assert promptTextArea.getText().equals("h");

            rob.keyPress(KeyEvent.VK_I);
            TimeUnit.SECONDS.sleep(1);
            rob.keyRelease(KeyEvent.VK_I);

            assert promptTextArea.getText().equals("hi");

        } catch(Exception ignored) {}

        JButton button = getButton();

        button.doClick();

        assert(!historyTextArea.getText().isEmpty());
    }

}
