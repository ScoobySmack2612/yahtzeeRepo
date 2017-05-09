package SourcePackages.controller;

/**
 * Created by Heron on 5/8/2017.
 */
public class Game {
    int userScore;
    int computerScore;

    public Game(){
        this.initScore();
    }
    private void initScore(){
        this.userScore = 0;
        this.computerScore = 0;
    }
    public int getScore(){
        return this.userScore;
    }
}
