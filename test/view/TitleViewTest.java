package test.view;

import src.app.Main;
import src.view.CreatePlayerView;
import src.view.GameView;
import src.view.TitleView;

import javax.swing.*;
import java.awt.*;

public class TitleViewTest {

    private TitleView getTitleView() {
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

        return (TitleView) jp2.getComponent(2);
    }

    private JPanel getActiveView() {
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

        JPanel current = null;

        for (Component jp3 : jp2.getComponents()) {
            if (jp3.isShowing()) {
                current = (JPanel) jp3;
            }
        }

        return current;
        //return (TitleView) jp2.getComponent(2);
    }

    private JPanel getButtons() {
        TitleView titleView = getTitleView();
        return (JPanel) titleView.getComponent(1);
    }

    @org.junit.Test
    public void testStartAndPlayerButtonsPresent() {
        Main.main(null);
        JButton button = (JButton) getButtons().getComponent(0);
        assert(button.getText().contains("START GAME"));
        button = (JButton) getButtons().getComponent(1);
        assert(button.getText().contains("CREATE A PLAYER"));
    }

    @org.junit.Test
    public void testStartGame() {
        Main.main(null);

        // Get Start Button
        JButton button = (JButton) getButtons().getComponent(0);
        assert(button.getText().contains("START GAME"));

        JPanel current = getActiveView();

        assert(current instanceof TitleView);

        button.doClick();

        current = getActiveView();

        assert(current instanceof GameView);
    }

    @org.junit.Test
    public void testCreatePlayer() {
        Main.main(null);

        // Get Start Button
        JButton button = (JButton) getButtons().getComponent(1);
        assert(button.getText().contains("CREATE A PLAYER"));

        JPanel current = getActiveView();

        assert(current instanceof TitleView);

        button.doClick();

        current = getActiveView();

        assert(current instanceof CreatePlayerView);
    }


}
