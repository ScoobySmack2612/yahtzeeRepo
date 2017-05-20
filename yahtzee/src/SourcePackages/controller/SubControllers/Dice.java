package SourcePackages.controller.SubControllers;

import javafx.collections.ObservableArray;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

/**
 * Created by Heron on 5/9/2017.
 */

public class Dice extends Rectangle{
    int value;
    ImagePattern image;
    ImagePattern[] diceImg = { new ImagePattern(new Image(getClass().getResource("../img/d1.png").toExternalForm())),new ImagePattern(new Image(getClass().getResource("../img/d2.png").toExternalForm())),new ImagePattern(new Image(getClass().getResource("../img/d3.png").toExternalForm())),new ImagePattern(new Image(getClass().getResource("../img/d4.png").toExternalForm())),new ImagePattern(new Image(getClass().getResource("../img/d5.png").toExternalForm())),new ImagePattern(new Image(getClass().getResource("../img/d6.png").toExternalForm()))};
    String clicked;

    public Dice(int value, int positionInRoll){
        this.value = value;
        this.image = diceImg[this.value-1];
        this.setFill(image);
        this.setWidth(50);
        this.setHeight(50);
        this.setId(Integer.toString(positionInRoll));
        this.setOnMouseClicked( e ->{
            clicked = this.getId();
            System.out.println(clicked);
        });
    }
    public int getValue(){return this.value;}
    public String getClicked(){return this.clicked;}
}
