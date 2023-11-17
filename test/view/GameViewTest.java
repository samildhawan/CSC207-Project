package test.view;

import src.app.Main;
import src.view.GameView;

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

    public GameView getGameView() {
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

    public JButton getButton() {
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

    public JScrollPane getHistoryTextArea() {
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

    public JTextArea getPromptTextArea() {
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

        // Hi is 72, 72
        try {
            promptTextArea.grabFocus();
            TimeUnit.SECONDS.sleep(5);
            Robot rob = new Robot();
            rob.keyPress(KeyEvent.VK_META);
            rob.keyPress(KeyEvent.VK_A);
            rob.keyRelease(KeyEvent.VK_META);
            rob.keyRelease(KeyEvent.VK_A);
            TimeUnit.SECONDS.sleep(1);
            rob.keyPress(KeyEvent.VK_DELETE);
            TimeUnit.SECONDS.sleep(10);
            rob.keyRelease(KeyEvent.VK_DELETE);
            TimeUnit.SECONDS.sleep(1);
            System.out.println(promptTextArea.getText());

            rob.keyPress(KeyEvent.VK_H);
            TimeUnit.SECONDS.sleep(1);
            // For every button press, I should also check GameState to see if it updated too
            rob.keyRelease(KeyEvent.VK_H);
            TimeUnit.SECONDS.sleep(1);

            System.out.println(promptTextArea.getText());
            assert promptTextArea.getText().equals("h");

            rob.keyPress(KeyEvent.VK_I);
            // For every button press, I should also check GameState to see if it updated too
            rob.keyRelease(KeyEvent.VK_I);

            assert promptTextArea.getText().equals("hi");

        } catch(Exception ignored) {}

        JButton button = getButton();

        button.doClick();

        assert(!historyTextArea.getText().isEmpty());
    }

}
