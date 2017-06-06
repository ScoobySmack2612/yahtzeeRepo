package SourcePackages.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Heron on 5/9/2017.
 */

public class User {
    String name;
    Scorecard sc;
    IntegerProperty score = new SimpleIntegerProperty(0);

    public User(String name){
        this.name = name;
        sc = new Scorecard();
    }
    public String getName(){return this.name;}
    public void setScore(int score){this.score.set(score);}
    public IntegerProperty getScore(){return this.score;}
    public String[] getUpperSectionCombos(){return sc.getUpperSectionCombos();}
    public String[] getLowerSectionCombos(){return sc.getLowerSectionCombos();}
    public void enterScore(String section, String comboName, int score){
        sc.enterScoreForCombo(section,comboName,score);

        this.score.set(sc.tallyScores());
    }
    public StringProperty getScoreToBind(String section, String comboName){
        String[] combos = sc.getUpperSectionCombos();
        for (int x = 0; x < combos.length; x++){
            if (combos[x].equals(comboName)) {
                return sc.getScoreForCombo(section,comboName);
            }
        }
        combos = sc.getLowerSectionCombos();
        for (int x = 0; x < combos.length; x++){
            if (combos[x].equals(comboName)){
                return sc.getScoreForCombo(section,comboName);
            }
        }
        return null;
    }
}
