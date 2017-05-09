package SourcePackages.model;

import java.util.ArrayList;

/**
 * Created by Heron on 5/3/2017.
 */
public class Combo {
    public Combo(){}

    public ArrayList<String> getUpperSection() {
        ArrayList<String> result = new ArrayList<>();
        String[] combos = {"Ones","Twos","Threes","Fours","Fives","Sixes"};
        for (String comboName : combos){
            result.add(comboName);
        }
        return result;
    }
    public ArrayList<String> getLowerSection(){
        ArrayList<String> result = new ArrayList<>();
        String[] combos = {"Three of a Kind", "Four of a Kind", "Full House", "Small Straight", "Large Straight", "Ha-Yahtzee","Chance"};
        for (String comboName : combos){
            result.add(comboName);
        }
        return result;
    }
}
