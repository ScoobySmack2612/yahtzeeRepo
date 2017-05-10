package SourcePackages.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

/**
 * Created by Heron on 5/9/2017.
 */
public class UpperSection {
    String[] combos = {"Ones", "Twos", "Threes","Fours","Fives","Sixes"};

    ObservableMap<String, Integer> scores = FXCollections.observableHashMap();
    public UpperSection(){
        this.initScores();
    }
    private void initScores(){
        for (String combo: this.combos ){
            scores.put(combo, 0);
        }
    }
    public ObservableMap<String, Integer> getScores(){return this.scores;}
}
