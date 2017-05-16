package SourcePackages.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Heron on 5/15/2017.
 */
public class Roll {
    Map<Integer, Dice> roll = new HashMap<>();
    public Roll(){
        this.initRoll();
    }
    private void initRoll(){
        this.randomRoll();
    }
    private void randomRoll(){
        for (int x = 0; x < 6; x ++){
            int rand =(int)(Math.random()*((5-1)+1)+1);
            Dice dice = new Dice(rand);

            roll.put(dice.getValue(),dice);
            //System.out.println(dice.getValue());
        }
    }
    public Map<Integer,Dice> getRoll(){return this.roll;}
}
