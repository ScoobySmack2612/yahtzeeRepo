package SourcePackages.controller;

import SourcePackages.controller.SubControllers.Turn;
import SourcePackages.model.User;
import SourcePackages.view.GameScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Created by Heron on 5/8/2017.
 */

public class GameController {
    Stage window;
    User human;
    User computer;
    GameScene view;
    int turn = 0;
    Turn turnObject;

    public GameController(User human, User ai){
        this.human = human;
        this.computer = ai;
        this.initGame();
    }
    private void initGame(){
        User[] users = {this.human,this.computer};
        this.getTurn();
        turnObject = new Turn();


    }
    private void getTurn(){
        /*if (this.turn == 0) {
            this.turn = (int)(Math.random() * ( 1 + 1 ) + 1);
            System.out.println(this.turn);
        }else{
            if (this.turn == 1){
                this.turn =2;
            }else if (this.turn == 2){
                this.turn=1;
            }
        }*/
        this.turn=1;
    }
    public void enterScore(String section,String comboName){
        human.enterScore(section, comboName);
    }
    public boolean checkIfUserTurn(){if(this.turn == 1){return true;}else{return false;}}
    public void handleInput(Button inputSelected){
        if (inputSelected.getId().equals("play")){
            //do something
        }else if (inputSelected.getId().equals("roll")){
            if (!turnObject.checkIfTurnFinished()) {
                turnObject.rollDie();
            }
            if (turnObject.checkIfTurnFinished()){
                inputSelected.setVisible(false);
            }
        }
    }
    public void getComboScoreToBind(String comboName,String section){
        human.bindScore(section,comboName);
    }

}
