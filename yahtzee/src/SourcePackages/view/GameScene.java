package SourcePackages.view;

import SourcePackages.controller.GameController;
import SourcePackages.controller.SubControllers.Dice;
import SourcePackages.model.User;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;

/**
 * Created by Heron on 5/8/2017.
 */

public class GameScene {
    Stage window;
    User[] users;
    Scene scene;
    boolean init = true;
    GameController controller;
    Button roll,play;
    public GameScene(Stage window, User[] users, GameController controller){
        this.window = window;
        this.users = users;
        this.controller = controller;

        BorderPane bp = new BorderPane();
        scene = new Scene(bp,400,600);

        HBox scorecards = new HBox();
        scorecards.setAlignment(Pos.CENTER);
        for (User user : this.users){
            VBox scoreCard = this.createScoreCard(user);
            scorecards.getChildren().add(scoreCard);
        }

        init = false;
        /*HBox input = this.getInputOptions();
        input.setAlignment(Pos.CENTER);
        HBox diceSection = this.renderDie();

        VBox inAndDie = new VBox();
        inAndDie.getChildren().addAll(diceSection,input);
        */
        bp.setCenter(scorecards);
        //bp.setBottom(inAndDie);

        window.setScene(scene);
    }
    private VBox createScoreCard(User user){
        scene.getStylesheets().add(getClass().getResource("../css/gamescene.css").toExternalForm());

        VBox result = new VBox();
        result.setId(user.getName());
        result.setPadding(new Insets(0,25,0,25));
        result.setStyle("-fx-font-size: 16;");

        Label name = new Label(user.getName()+": "+this.getUserScore(user));
        name.setPadding(new Insets(0,0,10,0));
        name.setAlignment(Pos.CENTER);
        result.getChildren().addAll(name);

        VBox sections = new VBox();

        Label upper = new Label("Upper Section");
        Label lower = new Label("Lower Section");

        sections.getChildren().add(upper);

        String[] upperSectionCombos = user.getUpperSectionCombos();

        for (String combo : upperSectionCombos){
            Label comboName = new Label(combo);
            Label scoreForCombo = new Label(user.getScoreForCombo(init,combo,"upper"));

            controller.getComboScoreToBind(scoreForCombo.getId(),upper.getText());
            Bindings.bindBidirectional(scoreForCombo, );

            scoreForCombo.setId(combo);
            scoreForCombo.getStyleClass().add("scorebox");
            scoreForCombo.setPrefSize(20,20);
            if (result.getId().equals(users[0].getName())) {
                scoreForCombo.setOnMouseClicked(e -> {
                    controller.enterScore(upper.getText(),comboName.getText());
                });
            }
            VBox sectionCombos = new VBox();
            sectionCombos.setPrefWidth(400);
            VBox sectionScores = new VBox();
            sectionScores.setAlignment(Pos.CENTER);
            sectionCombos.getChildren().add(comboName);
            sectionScores.getChildren().add(scoreForCombo);
            HBox comboAndScore = new HBox();
            comboAndScore.getChildren().addAll(sectionCombos,sectionScores);
            comboAndScore.getStyleClass().add("sectionComboAndScore");
            sections.getChildren().addAll(comboAndScore);
        }

        sections.getChildren().add(lower);

        String[] lowerSectionCombos = user.getLowerSectionCombos();
        for (String combo : lowerSectionCombos){
            Label comboName = new Label(combo);
            Label scoreForCombo = new Label(user.getScoreForCombo(init,combo,"lower"));
            scoreForCombo.getStyleClass().add("scorebox");
            scoreForCombo.setId(combo);
            VBox sectionCombos = new VBox();
            sectionCombos.setPrefWidth(400);
            VBox sectionScores = new VBox();
            sectionScores.setAlignment(Pos.CENTER);
            sectionCombos.getChildren().add(comboName);
            sectionScores.getChildren().add(scoreForCombo);
            HBox comboAndScore = new HBox();
            comboAndScore.getChildren().addAll(sectionCombos,sectionScores);
            comboAndScore.getStyleClass().add("sectionComboAndScore");
            sections.getChildren().addAll(comboAndScore);
            if (result.getId().equals(users[0].getName())) {
                scoreForCombo.setOnMouseClicked(e -> {
                    controller.enterScore(lower.getText(),comboName.getText());
                });
            }
        }
        result.getChildren().add(sections);
        return result;

    }
    private String getUserScore(User user){
        return user.getTotalScore();
    }
    /*private HBox renderDie(){
        HBox result = new HBox(5);
        result.setAlignment(Pos.CENTER);
        for (Dice dice : die){
            result.getChildren().add(dice);
        }
        return result;
    }
    private HBox getInputOptions(){
        HBox result = new HBox();
        roll = new Button("Roll Again");
        roll.setId("roll");
        play = new Button("Play Hand");
        play.setId("play");
        result.getChildren().addAll(roll,play);
        return result;
    }*/
}
