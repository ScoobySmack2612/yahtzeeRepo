package SourcePackages.model;

/**
 * Created by Heron on 5/9/2017.
 */
public class Turn {
    int rollsLeft;
    boolean turnFinished;
    public Turn(){
        this.initTurn();
    }
    private void initTurn(){
        this.rollsLeft = 3;
        this.turnFinished = false;
    }
    public void turnTaken(){
        this.rollsLeft --;
        if (this.rollsLeft == 0){
            this.turnFinished = true;
        }
    }
}
