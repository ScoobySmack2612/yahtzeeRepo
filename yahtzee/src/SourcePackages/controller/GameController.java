package SourcePackages.controller;

import SourcePackages.controller.SubControllers.Scoring;
import SourcePackages.model.Roll;
import SourcePackages.model.User;
import javafx.beans.property.IntegerProperty;
import javafx.scene.shape.Rectangle;

/**
 * Created by Heron on 5/8/2017.
 */

public class GameController {
    User human;
    User computer;
    Roll roll = new Roll();
    boolean[] diceClicked = {false, false, false, false, false};
    String[] sectionAndCombo;

    public GameController(User human, User ai){
        this.human = human;
        this.computer = ai;
        this.initGame();
    }
    private void initGame(){
        User[] users = {this.human,this.computer};
    }
    public IntegerProperty getDiceToBind(int dieNum){
        return roll.getDiceToBind(dieNum);
    }
    public void rollDice(){
        roll.randomRoll(diceClicked);
    }
    public void dieClicked(Rectangle die){
        if (die.getStyleClass().toString().equals("clicked")){
            die.getStyleClass().clear();
            diceClicked[Integer.parseInt(die.getId())] = false;
        }else {
            die.getStyleClass().add("clicked");
            diceClicked[Integer.parseInt(die.getId())] = true;
        }
    }
    public void setComboToScore(String[] comboProps){
        this.sectionAndCombo = comboProps;
    }
    public int getScoreForCombo(String comboName){
        return new Scoring(comboName,roll.getDiceValues()).getScoreForCombo();
    }
    public void enterScore(User user){
        String section = sectionAndCombo[0];
        String combo = sectionAndCombo[1];

        int[] diceValues = roll.getDiceValues();
        int score = new Scoring(combo,diceValues).getScoreForCombo();

        user.enterScore(section, combo, score);
    }


}
