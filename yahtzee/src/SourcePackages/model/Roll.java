package SourcePackages.model;

import SourcePackages.controller.SubControllers.Dice;

import java.util.ArrayList;

/**
 * Created by Heron on 5/15/2017.
 */
public class Roll {
    //ObservableArray<Dice> die = FXCollections.observableList(randomRoll());
    ArrayList<Dice> roll = new ArrayList<>();
    public Roll(){
        this.initRoll();
    }
    private void initRoll(){
        this.randomRoll();
    }
    private void randomRoll(){
        for (int x = 1; x < 6; x ++){
            int rand =(int)(Math.random()*((6-1)+1)+1);
            Dice dice = new Dice(rand,x);

            roll.add(dice);
        }
    }
    public ArrayList<Dice> getRoll(){return this.roll;}
}
