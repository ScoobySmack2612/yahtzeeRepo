package SourcePackages.model.SubModels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

/**
 * Created by Heron on 5/9/2017.
 */
public class UpperSection {
    String[] combos = {"Ones", "Twos", "Threes","Fours","Fives","Sixes"};
    ObservableMap<String, Integer> combosAndScores = FXCollections.observableHashMap();


    public UpperSection(){
        this.initScores();
    }
    private void initScores(){
        for (int x = 0; x < combos.length; x++ ){
            combosAndScores.put(combos[x],0);
        }
    }
    public String[] upperKeys(){return this.combos;}
    public ObservableMap<String, Integer> getCombosAndScores(){return this.combosAndScores;}
    public void enterScore(String comboName, int score){
        combosAndScores.replace(comboName,score);
    }
}
