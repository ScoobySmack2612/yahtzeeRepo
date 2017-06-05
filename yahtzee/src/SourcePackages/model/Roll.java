package SourcePackages.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Heron on 5/15/2017.
 */
public class Roll {
    private IntegerProperty firstDice = new SimpleIntegerProperty(this, "firstDice", 0);
    private IntegerProperty secondDice = new SimpleIntegerProperty(this, "secondDice", 0);
    private IntegerProperty thirdDice = new SimpleIntegerProperty(this, "thirdDice", 0);
    private IntegerProperty fourthDice = new SimpleIntegerProperty(this, "fourthDice", 0);
    private IntegerProperty fifthDice = new SimpleIntegerProperty(this, "fifthDice", 0);

    private IntegerProperty[] roll = {firstDice,secondDice,thirdDice,fourthDice,fifthDice};

    public Roll(){ boolean[] diceToRoll = {false,false,false,false,false}; this.randomRoll(diceToRoll);}
    public void randomRoll(boolean[] diceClicked) {
        for (int x = 0; x < diceClicked.length; x++) {
            if (!diceClicked[x]) {
                int rand = (int) (Math.random() * ((6 - 1) + 1) + 1);
                roll[x].set(rand);
            }
        }
    }
    public IntegerProperty getDiceToBind(int position){return roll[position];}
    public int[] getDiceValues(){
        int[] result = new int[5];
        for (int x = 0; x < roll.length; x++){
            result[x] = roll[x].getValue();
        }
        return result;
    }
}
