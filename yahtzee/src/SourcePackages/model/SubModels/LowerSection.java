package SourcePackages.model.SubModels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

/**
 * Created by Heron on 5/9/2017.
 */
public class LowerSection {
    String[] combos = {"Three of a Kind", "Four of a Kind", "Full House","Small Straight","Large Straight","Ha-Yahtzee","Chance"};

    ObservableMap<String, Integer> combosAndScores = FXCollections.observableHashMap();
    public LowerSection(){
        this.initScores();
    }
    private void initScores(){
        for (String combo: this.combos ){
            combosAndScores.putIfAbsent(combo, 0);
        }
    }
    public String[] lowerKeys(){return this.combos;}
    public ObservableMap<String, Integer> getCombosAndScores(){return this.combosAndScores;}
    public void enterScore(String comboName, int score){
        combosAndScores.replace(comboName,score);
    }
}