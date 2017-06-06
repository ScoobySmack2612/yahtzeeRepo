package SourcePackages.controller.SubControllers;

import SourcePackages.model.Roll;

import java.util.ArrayList;

/**
 * Created by Heron on 5/9/2017.
 */

public class Turn {
    int rollsLeft;

    public Turn(){
        this.initTurn();
    }

    private void initTurn(){
        this.rollsLeft = 3;
    }
    public void rollTaken(){this.rollsLeft --;}
    public int getRollsLeft(){return this.rollsLeft;}
}
