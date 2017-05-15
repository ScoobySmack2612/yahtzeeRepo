package SourcePackages.model;

import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Heron on 5/9/2017.
 */

public class Dice {
    ImagePattern[] diceImg = { new ImagePattern(new Image(getClass().getResource("../img/d1.png").toExternalForm())),new ImagePattern(new Image(getClass().getResource("../img/d2.png").toExternalForm())),new ImagePattern(new Image(getClass().getResource("../img/d3.png").toExternalForm())),new ImagePattern(new Image(getClass().getResource("../img/d4.png").toExternalForm())),new ImagePattern(new Image(getClass().getResource("../img/d5.png").toExternalForm())),new ImagePattern(new Image(getClass().getResource("../img/d6.png").toExternalForm()))};
    Map<Integer, Rectangle> dice = new HashMap<>();
    public Dice(){
        this.initDie();
    }
    private void initDie(){
        for (int x = 1; x <=6; x++){
            Rectangle rectangle=new Rectangle(20,20);
            rectangle.setFill(diceImg[x-1]);
            dice.put(x, rectangle);
        }
    }
    public ArrayList<Integer> getDieNumbers(){
        ArrayList<Integer> diceNums = new ArrayList<>();
        for (Integer num : dice.keySet()){
            diceNums.add(num);
        }
        return diceNums;
    }
    public Rectangle getDiceByNumber(int key){
        return dice.get(key);
    }
    public ArrayList<Rectangle> getRandomDie(){
        ArrayList<Rectangle> die = new ArrayList<>();
        for (int x = 0; x < 6; x ++){
            int rand =(int)(Math.random()+5)+1;
            die.add(this.getDiceByNumber(rand));
        }
        return die;
    }
}
