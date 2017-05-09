package SourcePackages.view;

import SourcePackages.controller.Game;
import SourcePackages.model.Score;
import javafx.collections.ObservableMap;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Set;

/**
 * Created by Heron on 5/8/2017.
 */
public class GameScene {
    ObservableMap<String, Integer> scores = new Score().getScores();

    int totalUserScore = new Game().getScore();
    int totalComputerScore = new Game().getScore();
    public GameScene(Stage window){
        //game elements
        Label user = new Label("Your name here");
        Label ai = new Label("Heron's AI");

        Label userScoreLabel = new Label("Score: "+totalUserScore);
        Label aiScoreLabel = new Label("Score: "+totalComputerScore);

        HBox gameTopLabels = new HBox(50);
        gameTopLabels.getChildren().addAll(userScoreLabel,aiScoreLabel);

        int[] numUsers = new int[2];
        HBox scoreTable = new HBox();
        for (int x =0; x < numUsers.length; x++){
            FlowPane upperSection = new FlowPane(2,20);
            upperSection.setPrefWrapLength(300);

            Set<String> scoreKeys = scores.keySet();
            for (String key : scoreKeys){
                HBox score = new HBox();
                score.getChildren().addAll(new Label(key),new Rectangle(20,20));
            }


            FlowPane lowerSection = new FlowPane(2,20);
            lowerSection.setPrefWrapLength(300);

            HBox scoreboard = new HBox();
            scoreboard.getChildren().addAll(upperSection,lowerSection);
            scoreTable.getChildren().add(scoreboard);
        }

        BorderPane bp = new BorderPane();
        bp.setTop(gameTopLabels);
        bp.setCenter(scoreTable);

        Scene scene = new Scene(bp,450,450);

        window.setScene(scene);
    }
}
