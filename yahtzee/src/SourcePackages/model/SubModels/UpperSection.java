package SourcePackages.model.SubModels;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Heron on 5/9/2017.
 */
public class UpperSection {
    String[] combos = {"Ones", "Twos", "Threes","Fours","Fives","Sixes"};
    int[] scores = {0,0,0,0,0,0};

    StringProperty ones = new SimpleStringProperty(this, "ones", "  ");
    StringProperty twos = new SimpleStringProperty(this,"twos","  ");
    StringProperty threes = new SimpleStringProperty(this,"threes","  ");
    StringProperty fours = new SimpleStringProperty(this,"fours","  ");
    StringProperty fives = new SimpleStringProperty(this,"fives","  ");
    StringProperty sixes = new SimpleStringProperty(this,"sixes","  ");

    StringProperty[] scoresAsProp = {ones,twos,threes,fours,fives,sixes};

    public UpperSection(){}
    public int[] getScores(){return this.scores;}
    public String[] getCombos(){return this.combos;}

    public StringProperty[] getScoresAsProps(){return this.scoresAsProp;}
}
