package SourcePackages.controller.SubControllers;

import java.util.Arrays;

/**
 * Created by Heron on 6/2/2017.
 */
public class Scoring {
    String comboName;
    int[] rollValues;
    int[] diceValues = new int[7];

    public Scoring(String comboName,int[] rollValues){
        this.comboName = comboName;
        this.rollValues = rollValues;
    }
    public int getScoreForCombo(){
        switch(this.comboName){
            case "Ones": return this.getOnes();
            case "Twos": return this.getTwos();
            case "Threes": return this.getThrees();
            case "Fours": return this.getFours();
            case "Fives": return this.getFives();
            case "Sixes": return this.getSixes();
            case "Three of a Kind": return this.getTok();
            case "Four of a Kind": return this.getFok();
            case "Full House": return this.getFh();
            case "Small Straight": return this.getSs();
            case "Large Straight": return this.getLs();
            case "Ha-yahtzee": return this.getHy();
            case "Chance": return this.getChance();
        }
        return 0;
    }
    private int getOnes(){
        int result = 0;

        for (int value : rollValues){
            if (value == 1){
                result +=1;
            }
        }

        return result;
    }
    private int getTwos(){
        int result = 0;

        for (int value : rollValues){
            if (value == 2){
                result +=2;
            }
        }

        return result;
    }
    private int getThrees(){
        int result = 0;

        for (int value : rollValues){
            if (value == 3){
                result +=3;
            }
        }

        return result;
    }
    private int getFours(){
        int result = 0;

        for (int value : rollValues){
            if (value == 4){
                result +=4;
            }
        }

        return result;
    }
    private int getFives(){
        int result = 0;

        for (int value : rollValues){
            if (value == 5){
                result +=5;
            }
        }

        return result;
    }
    private int getSixes(){
        int result = 0;

        for (int value : rollValues){
            if (value == 6){
                result +=6;
            }
        }

        return result;
    }
    private int getTok(){
        int result = 0;
        int duplicateValue = 0;

        for (int value : rollValues){
            diceValues[value] ++;
            result = result + value;
        }
        for (int index = 1; index < diceValues.length; index++){
            if (diceValues[index]==3){
                duplicateValue = diceValues[index];
                break;
            }
        }
        if (duplicateValue == 0 ){
            return 0;
        }
        return result;
    }
    private int getFok(){
        int result = 0;
        int duplicateValue = 0;

        for (int value : rollValues){
            diceValues[value] ++;
            result = result + value;
        }
        for (int index = 1; index < diceValues.length; index++){
            if (diceValues[index]==4){
                duplicateValue = diceValues[index];
                break;
            }
        }
        if (duplicateValue == 0 ){
            return 0;
        }
        return result;
    }
    private int getFh(){
        int result = 0;
        int pairValue = 0;
        int tripleValue = 0;


        for (int value : rollValues){
            diceValues[value] ++;
            result = result + diceValues[value];
        }
        for (int index = 1; index < diceValues.length; index++){
            if (diceValues[index]==2){
                pairValue = diceValues[index];
            }
            if (diceValues[index]==3){
                tripleValue = diceValues[index];
            }
        }
        if (pairValue == 0 || tripleValue == 0 ){
            return 0;
        }

        return result;
    }
    private int getSs(){
        int result = 30;
        int counter = 1;

        for (int value : rollValues){
            diceValues[value] ++;
        }

        Arrays.sort(this.rollValues);
        for (int index = 0; index < rollValues.length-1; index++){

            if ( rollValues[index+1] - rollValues[index] == 1) {
                counter++;
            }

        }
        if (counter != 4){
            return 0;
        }

        return result;
    }
    private int getLs(){
        int result = 40;
        int counter = 1;

        for (int value : rollValues){
            diceValues[value] ++;
        }

        Arrays.sort(this.rollValues);
        for (int index = 0; index < rollValues.length-1; index++){

            if ( rollValues[index+1] - rollValues[index] == 1) {
                counter++;
            }
        }
        if (counter != 5){
            return 0;
        }

        return result;
    }
    private int getHy(){
        int result = 0;
        int duplicateValue = 0;

        for (int value : rollValues){
            diceValues[value] ++;
            result = result + diceValues[value];
        }
        for (int index = 1; index < diceValues.length; index++){
            diceValues[index] ++;
            if (diceValues[index]==5){
                duplicateValue = diceValues[index];
                break;
            }
        }
        if (duplicateValue == 0 ){
            return 0;
        }
        return result;
    }
    private int getChance(){
        int result = 0;
        for (int value : rollValues){
            result = result + diceValues[value];
        }
        return result;
    }
}
