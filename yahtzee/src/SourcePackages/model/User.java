package SourcePackages.model;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

/**
 * Created by Heron on 5/9/2017.
 */
public class User {
    String name;
    int totalScore;

    ObservableMap<String, Integer> upperSectionScores = FXCollections.observableHashMap();
    ObservableMap<String, Integer> lowerSectionScores = FXCollections.observableHashMap();

    public User(){
        this.initUser();
    }

    private void initUser(){
        this.upperSectionScores = upperSectionScores.put(new UpperSection().getScores());
        this.lowerSectionScores = new LowerSection().getScores();

        this.totalScore = this.tallyScores();
    }
    public ObservableMap<String, Integer> getUpperSectionScores(){return this.upperSectionScores;}
    public ObservableMap<String, Integer> getLowerSectionScores(){return this.lowerSectionScores;}

    public int tallyScores(){
        int counter = 0;
        for (int x = 0; x < upperSectionScores.size(); x++){
            int val = this.upperSectionScores.get(x);
            counter = val + counter;
        }
        return counter;
    }
    public String getName(){return this.name;}
    public String getScoreAsString(){return Integer.toString(totalScore);}
}
