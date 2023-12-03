package test.view;

import src.app.Main;
import src.entity.CreatePlayer;
import src.entity.Player;
import src.view.CreatePlayerView;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreatePlayerViewTest {

    public CreatePlayerView getCreatePlayerView(){
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
    }
        assertNotNull(app);
        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        return (CreatePlayerView) jp2.getComponent(0);
    }

    public JButton getButton(){
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
    }
        assertNotNull(app);

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        CreatePlayerView sv = (CreatePlayerView) jp2.getComponent(0);

        JPanel buttons = (JPanel) sv.getComponent(2);

        return (JButton) buttons.getComponent(0);
    }

    public JScrollPane getHistoryTextArea() {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }
        assertNotNull(app);

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        CreatePlayerView sv = (CreatePlayerView) jp2.getComponent(0);

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

        assertNotNull(app);

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        CreatePlayerView sv = (CreatePlayerView) jp2.getComponent(0);

        return (JTextArea) sv.getComponent(1);
    }

    @org.junit.Test
    public void testCreatePlayer() {
        // Create a player with sample data
        Player player = new CreatePlayer("John Doe", 0,2, "Warrior", "A brave warrior with a mysterious past.");

        // Check if the player's attributes are set correctly
        assertEquals("John Doe", player.getName());
        assertEquals(2, player.getXP());
        assertEquals("Warrior", player.getClassType());
        assertEquals("A brave warrior with a mysterious past.", player.getBackstory());    // Assuming initial XP is 0

        // Test adding XP to the player
        player.addXP(100);
        assertEquals(100, player.getXP());

    }
    @org.junit.Test
    public void testSubmitButtonPresent() {
        Main.main(null);
        CreatePlayerView createPlayerView = getCreatePlayerView();
        JButton button = getButton();
        assert(button.getText().equals("Submit"));
    }



}

