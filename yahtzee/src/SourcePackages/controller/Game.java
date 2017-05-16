package SourcePackages.controller;

import SourcePackages.model.Dice;
import SourcePackages.model.Roll;
import SourcePackages.model.User;
import SourcePackages.view.GameScene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Map;

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
        Map<Integer, Dice> roll = this.takeRoll();
        ArrayList<Dice> die = this.getDiceRects(roll);

        this.view = new GameScene(window, users,this,die);
    }
    public void enterScore(Label clicked){
        clicked.setText("2");
    }
    private Map<Integer,Dice> takeRoll(){return  new Roll().getRoll();}
    private ArrayList<Dice> getDiceRects(Map<Integer, Dice> roll){
        ArrayList<Dice> die = new ArrayList<>();
        for (Dice dice : roll.values()){
            System.out.println(dice.getValue());
            die.add(dice);
        }
        return die;
    }


}
