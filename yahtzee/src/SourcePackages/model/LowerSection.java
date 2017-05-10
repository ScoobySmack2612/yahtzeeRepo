package SourcePackages.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

/**
 * Created by Heron on 5/9/2017.
 */
public class LowerSection {
    String[] combos = {"Three of a Kind", "Four of a Kind", "Full House","Small Straight","Large Straight","Ha-Yahtzee","Chance"};

    ObservableMap<String, Integer> scores = FXCollections.observableHashMap();
    public LowerSection(){
        this.initScores();
    }
    private void initScores(){
        for (String combo: this.combos ){
            scores.put(combo, 0);
        }
    }
    public ObservableMap<String, Integer> getScores(){return this.scores;}
}
