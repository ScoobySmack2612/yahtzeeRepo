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
        int result = 0;
        int[] upperScores = us.getScores();
        int[] lowerScores = ls.getScores();

        for (int score : upperScores){
            result = result + score;
        }
        for (int score : lowerScores){
            result = result + score;
        }
        return result;
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
