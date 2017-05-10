package SourcePackages.controller;

import SourcePackages.model.User;
import SourcePackages.view.GameScene;
import javafx.stage.Stage;

/**
 * Created by Heron on 5/8/2017.
 */
public class Game {
    Stage window;
    GameScene view;
    User human;
    User computer;

    public Game(Stage window){
        this.window = window;
        this.initGame();
    }
    private void initGame(){
        this.human = new User();
        this.computer = new User();
        User[] users = {this.human,this.computer};

        this.view = new GameScene(window, users);


    }

}
