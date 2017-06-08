package SourcePackages.controller.SubControllers;

import SourcePackages.controller.GameController;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Heron on 6/7/2017.
 */
public class AI {
    GameController controller;
    int[] rollValues;
    ArrayList<Integer> scoreValues = new ArrayList<>();
    public AI(GameController controller) {
        this.controller = controller;
        this.executeFirstRoll();
    }
    private void executeFirstRoll(){
        controller.rollDice();
        this.rollValues = controller.getRollValues();
        this.setScoreValues();

        Collections.sort(this.scoreValues, Collections.reverseOrder());


    }
    private void setScoreValues(){
        for (int score : controller.getScoresForRoll()){
            if (score != 0){
                scoreValues.add(score);
            }
        }
    }
    private String getComboForScore(){

    }

}
