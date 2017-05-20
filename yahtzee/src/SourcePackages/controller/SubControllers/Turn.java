package SourcePackages.controller.SubControllers;

import SourcePackages.model.Roll;

import java.util.ArrayList;

/**
 * Created by Heron on 5/9/2017.
 */

public class Turn {
    int rollsLeft;
    boolean turnFinished;
    public Turn(){
        this.initTurn();
    }
    private void initTurn(){
        this.rollsLeft = 3;
    }
    public boolean checkIfTurnFinished(){
        return this.turnFinished;
    }
    public ArrayList<Dice> rollDie(){
        if (!checkIfTurnFinished()){
            Roll roll = new Roll();
            this.rollsLeft--;
            return roll.getRoll();
        }
        return null;
    }
}
