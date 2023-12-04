package src.app;

import com.formdev.flatlaf.FlatLightLaf;
import src.data_access.APIAccessObject;
import src.entity.CommonPlayerBuilder;
import src.interface_adapter.ViewManagerModel;
import src.interface_adapter.create_player.CreatePlayerViewModel;
import src.interface_adapter.game.GameViewModel;
import src.interface_adapter.title.TitleViewModel;
import src.view.GameView;
import src.view.CreatePlayerView;
import src.view.TitleView;
import src.view.ViewManager;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        FlatLightLaf.setup();

        JFrame application = new JFrame("Game");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        GameViewModel gameViewModel = new GameViewModel();
        CreatePlayerViewModel createPlayerViewModel = new CreatePlayerViewModel();
        APIAccessObject apiAccessObject = new APIAccessObject("./users.csv", new CommonPlayerBuilder());
        TitleViewModel titleViewModel = new TitleViewModel();

        GameView gameView = GameUseCaseFactory.create(viewManagerModel, gameViewModel, apiAccessObject);
        CreatePlayerView createPlayerView = CreatePlayerUseCaseFactory.create(viewManagerModel, createPlayerViewModel, apiAccessObject);
        TitleView titleView = TitleUseCaseFactory.create(titleViewModel, viewManagerModel, gameViewModel, createPlayerViewModel);
        views.add(gameView, gameView.viewName);
        views.add(createPlayerView, createPlayerView.viewName);
        views.add(titleView, titleView.viewName);

        viewManagerModel.setActiveView(titleView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}
