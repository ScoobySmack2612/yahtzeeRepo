package SourcePackages.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import java.util.Set;

/**
 * Created by Heron on 5/9/2017.
 */

public class User {
    String name;
    int totalScore;
    UpperSection us;
    LowerSection ls;
    ObservableMap<String, Integer> upperSectionScores = FXCollections.observableHashMap();
    ObservableMap<String, Integer> lowerSectionScores = FXCollections.observableHashMap();

    public User(String name){
        this.name = name;

        this.initUser();
    }

    private void initUser(){
        us = new UpperSection();
        ls = new LowerSection();
        this.upperSectionScores = us.getUpperCombosAndScores();
        this.lowerSectionScores = ls.getScores();

        this.totalScore = this.tallyScores();
    }
    public int tallyScores(){
        Set<String> combos = upperSectionScores.keySet();
        int counter = 0;
        for (String combo : combos){
            if (upperSectionScores.get(combo)!=null) {
                int score = upperSectionScores.get(combo);
                counter = counter + score;
            }else{
                counter = counter + 0;
            }
        }
        return counter;
    }
    public String getScoreForCombo(Boolean init, String key, String section){
        if (section.equals("upper")){
            try{
                if (init && this.getUpperSectionScoreByKey(key)==0) {
                    return "  ";
                }else{
                    return Integer.toString(this.getUpperSectionScoreByKey(key));
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }else if (section.equals("lower")){
            try{
                if (init && this.getLowerSectionScoreByKey(key)==0) {
                    return "  ";
                }else{
                    return Integer.toString(this.getLowerSectionScoreByKey(key));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
    public String getName(){return this.name;}
    public String getTotalScoreAsString(){return Integer.toString(totalScore);}
    public String[] getUpperSectionCombos(){return us.upperKeys();}
    public String[] getLowerSectionKeySet(){return ls.lowerKeys();}
    public int getUpperSectionScoreByKey(String valueForKey){return upperSectionScores.get(valueForKey);}
    public int getLowerSectionScoreByKey(String valueForKey){return lowerSectionScores.get(valueForKey);}
}
