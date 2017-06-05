package SourcePackages.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Heron on 5/9/2017.
 */

public class User {
    String name;
    Scorecard sc;
    String totalScore;

    public User(String name){
        this.name = name;
        sc = new Scorecard();
        this.initUser();
    }
    private void initUser(){this.totalScore = sc.getTotalScoreAsString();}
    public String getName(){return this.name;}
    public String getTotalScore(){ return sc.getTotalScoreAsString(); }
    public String[] getUpperSectionCombos(){return sc.getUpperSectionCombos();}
    public String[] getLowerSectionCombos(){return sc.getLowerSectionCombos();}
    public void enterScore(String section, String comboName, int score){
        sc.enterScoreForCombo(section,comboName,score);
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
