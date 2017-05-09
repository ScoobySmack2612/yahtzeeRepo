package SourcePackages.model;

import com.sun.javafx.collections.ObservableMapWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

import java.util.ArrayList;

/**
 * Created by Heron on 5/3/2017.
 */
public class Score {
    ObservableMap<String, Integer> scores = FXCollections.observableHashMap();

    public Score(){
        this.setInitialScores();
    }

    private void setInitialScores(){
        ArrayList<String> upperSection = new ArrayList<>(new Combo().getUpperSection());
        ArrayList<String> lowerSection = new ArrayList<>(new Combo().getLowerSection());

        for (String name : upperSection){
            scores.put(name,0);
        }
        for (String name : lowerSection){
            scores.put(name,0);
        }
    }
    public ObservableMap<String, Integer> getScores(){
        return this.scores;
    }

}
