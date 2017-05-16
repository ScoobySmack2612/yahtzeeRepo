package SourcePackages.controller;

import SourcePackages.model.Dice;
import SourcePackages.model.Roll;
import SourcePackages.model.User;
import SourcePackages.view.GameScene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Heron on 5/8/2017.
 */
public class Game {
    Stage window;
    User human;
    User computer;
    GameScene view;

    public Game(Stage window, String usersName){
        this.window = window;

        this.initGame(usersName);
    }
    private void initGame(String usersName){
        this.human = new User(usersName);
        this.computer = new User("Heron's AI");
        User[] users = {this.human,this.computer};
        ArrayList<Dice> roll = this.takeRoll();

        this.view = new GameScene(window, users,this,roll);
    }
    public void enterScore(Label clicked){
        clicked.setText("2");
    }
    private ArrayList<Dice> takeRoll(){
        ArrayList<Dice> die = new ArrayList<>();
        Roll roll = new Roll();
        for (Dice dice : roll.getRoll()){
            System.out.println(dice);
            die.add(dice);
        }
        return die;
    }


}
