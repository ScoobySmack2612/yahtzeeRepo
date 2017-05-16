package SourcePackages.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Heron on 5/15/2017.
 */
public class Roll {
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

            //First output -- shows all five dice values
            System.out.println(dice.getValue());
        }
    }
    public ArrayList<Dice> getRoll(){return this.roll;}
}
