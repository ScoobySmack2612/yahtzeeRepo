package SourcePackages.model.SubModels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

/**
 * Created by Heron on 5/9/2017.
 */
public class LowerSection {
    String[] combos = {"Three of a Kind", "Four of a Kind", "Full House","Small Straight","Large Straight","Ha-Yahtzee","Chance"};
    int[] scores = {0,0,0,0,0,0,0};

    StringProperty tok = new SimpleStringProperty(this, "Three O' Kind", "  ");
    StringProperty fok = new SimpleStringProperty(this,"Four O' Kind","  ");
    StringProperty fh = new SimpleStringProperty(this,"Full House","  ");
    StringProperty ss = new SimpleStringProperty(this,"Small Straight","  ");
    StringProperty ls = new SimpleStringProperty(this,"Large Straight","  ");
    StringProperty hy = new SimpleStringProperty(this,"Ha-Yahtzee","  ");
    StringProperty ch = new SimpleStringProperty(this,"Chance","  ");

    StringProperty[] scoresAsProps = {tok,fok,fh,ss,ls,hy,ch};

    public LowerSection(){}
    public String[] getCombos(){return this.combos;}
    public int[] getScores(){return this.scores;}
    public StringProperty[] getScoresAsProps(){return this.scoresAsProps;}

}
