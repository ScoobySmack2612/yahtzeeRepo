package SourcePackages.controller;

import SourcePackages.model.Dice;
import SourcePackages.model.User;
import SourcePackages.view.GameScene;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Heron on 5/8/2017.
 */
public class Game {
    Stage window;
    User human;
    User computer;
    Dice diceObject;
    GameScene view;

    public Game(Stage window, String usersName){
        this.window = window;

        this.initGame(usersName);
    }
    private void initGame(String usersName){
        this.human = new User(usersName);
        this.computer = new User("Heron's AI");
        User[] users = {this.human,this.computer};
        diceObject = new Dice();

        this.view = new GameScene(window, users,this,diceObject);
    }
    public void enterScore(Label clicked){
        clicked.setText("2");
    }
    public ArrayList<Rectangle> getDie(){
        return diceObject.getRandomDie();
    }


}
