package SourcePackages;

import SourcePackages.controller.GameController;
import SourcePackages.model.User;
import SourcePackages.view.GameScene;
import javafx.stage.Stage;

/**
 * Created by Heron on 5/19/2017.
 */

public class Game {
    GameController controller;
    GameScene view;
    User human;
    User ai;
    public Game(Stage window, String usersName){
        this.human = new User(usersName);
        this.ai = new User("Heron's AI");

        this.controller = new GameController(human,ai);

        User[] users = {human, ai};
        this.view = new GameScene(window,users,controller);

    }
}
