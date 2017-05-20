package SourcePackages.model;

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
    public String getScoreForCombo(boolean init, String comboName, String section){return sc.getScoreForCombo(init,comboName,section);}
    public void enterScore(String section, String comboName){
        sc.enterScoreForCombo(section,comboName);
    }
    public int bindScore(String section, String comboName){
        sc.getScoreProp();
    }
}
