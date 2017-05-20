package SourcePackages.model;

import SourcePackages.model.SubModels.LowerSection;
import SourcePackages.model.SubModels.UpperSection;
import javafx.collections.ObservableMap;

import java.util.Set;

/**
 * Created by Heron on 5/19/2017.
 */

public class Scorecard {
    UpperSection us = new UpperSection();
    ObservableMap<String, Integer> upperSection = us.getCombosAndScores();
    LowerSection ls = new LowerSection();
    ObservableMap<String, Integer> lowerSection = ls.getCombosAndScores();
    public Scorecard(){
        this.initScorecard();
    }
    private void initScorecard(){
        us = new UpperSection();
        ls = new LowerSection();
    }
    public ObservableMap<String, Integer> getUpperSection(){
        return us.getCombosAndScores();
    }
    public ObservableMap<String, Integer> getLowerSection(){
        return ls.getCombosAndScores();
    }
    public int tallyScores(){
        Set<String> combos = upperSection.keySet();
        int counter = 0;
        for (String combo : combos){
            if (upperSection.get(combo)!=null) {
                int score = upperSection.get(combo);
                counter = counter + score;
            }
        }
        combos = lowerSection.keySet();
        for(String combo: combos){
            if (lowerSection.get(combo)!=null) {
                int score = lowerSection.get(combo);
                counter = counter + score;
            }
        }
        return counter;
    }
    public String[] getUpperSectionCombos(){return us.upperKeys();}
    public String[] getLowerSectionCombos(){return ls.lowerKeys();}
    public int getUpperSectionScoreByKey(String valueForKey){return upperSection.get(valueForKey);}
    public int getLowerSectionScoreByKey(String valueForKey){return lowerSection.get(valueForKey);}
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
    public String getTotalScoreAsString(){return Integer.toString(this.tallyScores());}
    public void enterScoreForCombo(String section, String comboName){
        if (section.contains("Upper")){
            us.enterScore(comboName,5);
        }else if (section.contains("Lower")){
            ls.enterScore(comboName,5);
        }
    }
}
