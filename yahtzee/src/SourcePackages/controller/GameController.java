package SourcePackages.controller;

import SourcePackages.controller.SubControllers.Scoring;
import SourcePackages.controller.SubControllers.Turn;
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
    Turn turn;
    int whosTurn = 0;

    public GameController(User human, User ai){
        this.human = human;
        this.computer = ai;
        this.initGame();
    }
    private void initGame(){
        User[] users = {this.human,this.computer};
        this.setWhosTurn();
    }
    public IntegerProperty getUserScore(User user){
        return user.getScore();
    }
    public IntegerProperty getDiceToBind(int dieNum){
        return roll.getDiceToBind(dieNum);
    }
    public void rollDice(){
        roll.randomRoll(diceClicked);
        if (!this.isTurnOver()) {
            turn.rollTaken();
            return;
        }
    }
    public void dieClicked(Rectangle die) {
        if (die.getStyleClass().toString().equals("clicked")) {
            die.getStyleClass().clear();
            diceClicked[Integer.parseInt(die.getId())] = false;
        } else {
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
    private void setWhosTurn(){
        if (whosTurn == 0){
            whosTurn = (int) (Math.random() * ((2 - 1) + 1) + 1);
        }else if ( whosTurn == 1){
            whosTurn = 2;
        }else if ( whosTurn == 2){
            whosTurn = 1;
        }
        turn = new Turn();
        System.out.println(whosTurn);
    }
    public boolean isTurnOver(){
        boolean result = turn.getRollsLeft() == 0;
        if (result){
            this.setWhosTurn();
        }
        return result;
    }
    public boolean setTurnFinished(){
        this.setWhosTurn();
        return true;
    }
    public int getWhosTurn(){return this.whosTurn;}
}
