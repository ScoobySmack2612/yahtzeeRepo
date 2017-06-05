package SourcePackages.model;

import SourcePackages.model.SubModels.LowerSection;
import SourcePackages.model.SubModels.UpperSection;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Heron on 5/19/2017.
 */

public class Scorecard {
    UpperSection us = new UpperSection();
    LowerSection ls = new LowerSection();

    public Scorecard(){}

    public int tallyScores(){
        int[] scores = us.getScores();
        int counter = 0;
        for (int score : scores){
            counter = counter + score;
        }
        /*scores = ls.getScores();
        for (IntegerProperty score : scores){
            counter = counter + score.getValue();
        }*/
        return counter;
    }
    public String[] getUpperSectionCombos(){return us.getCombos();}
    public String[] getLowerSectionCombos(){return ls.getCombos();}
    public StringProperty getScoreForCombo(String section, String comboName){
        if (section.equals("Upper Section")){
            String[] combos = getUpperSectionCombos();
            for (int x = 0; x < combos.length; x++){
                if (combos[x].equals(comboName)) {
                    StringProperty[] scores = us.getScoresAsProps();
                    return scores[x];
                }
            }
        }else if (section.equals("Lower Section")){
            String[] combos = getLowerSectionCombos();
            for (int x = 0; x < combos.length; x++){
                if (combos[x].equals(comboName)) {
                    StringProperty[] scores = ls.getScoresAsProps();
                    return scores[x];
                }
            }
        }
        return null;
    }
    public String getTotalScoreAsString(){return Integer.toString(this.tallyScores());}
    public void enterScoreForCombo(String section, String comboName,int score){
        if (section.equals("Upper Section")){
            String[] combos = us.getCombos();
            for (int x = 0; x < combos.length; x++){
                if (combos[x].equals(comboName)){
                    StringProperty[] scoresAsProps = us.getScoresAsProps();
                    int[] scores = us.getScores();
                    scoresAsProps[x].setValue(Integer.toString(score));
                    scores[x] = score;
                }
            }
        }else if (section.equals("Lower Section")){
            String[] combos = ls.getCombos();
            for (int x = 0; x < combos.length; x++){
                if (combos[x].equals(comboName)){
                    StringProperty[] scoresAsProps = ls.getScoresAsProps();
                    int[] scores = ls.getScores();
                    scoresAsProps[x].setValue(Integer.toString(score));
                    scores[x] = score;
                }
            }
        }
    }
}
