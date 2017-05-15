package SourcePackages.view;

import SourcePackages.controller.Game;
import SourcePackages.model.Dice;
import SourcePackages.model.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
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
    Game controller;
    Dice dieObject;
    public GameScene(Stage window, User[] users, Game controller,Dice dice){
        this.window = window;
        this.users = users;
        this.controller = controller;
        this.dieObject = dice;

        BorderPane bp = new BorderPane();
        scene = new Scene(bp,400,600);
        HBox scorecards = new HBox();
        scorecards.setAlignment(Pos.CENTER);
        for (User user : users){
            VBox scoreCard = this.createScoreCard(user);
            scorecards.getChildren().add(scoreCard);
        }

        init = false;
        ArrayList<Rectangle> die = this.randomizeDie();
        HBox diceSection = this.renderDie(die);
        bp.setCenter(scorecards);
        bp.setBottom(diceSection);

        window.setScene(scene);
        window.setResizable(false);
    }
    private VBox createScoreCard(User user){
        scene.getStylesheets().add(getClass().getResource("../css/gamescene.css").toExternalForm());
        VBox result = new VBox();
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

        ArrayList<String> upperSectionCombos = this.getUpperSectionCombos(user);

        for (String combo : upperSectionCombos){
            Label comboName = new Label(combo);
            Label scoreForCombo = new Label(user.getScoreForCombo(init,combo,"upper"));
            scoreForCombo.setId(combo);
            scoreForCombo.getStyleClass().add("scorebox");
            scoreForCombo.setPrefSize(20,20);
            scoreForCombo.setOnMouseClicked(e ->{
                controller.enterScore(scoreForCombo);
            });
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

        ArrayList<String> lowerSectionCombos = this.getLowerSectionCombos(user);
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
            scoreForCombo.setOnMouseClicked(e ->{
                controller.enterScore(scoreForCombo);
            });
        }
        result.getChildren().add(sections);
        return result;

    }
    private String getUserScore(User user){
        return user.getTotalScoreAsString();
    }
    private ArrayList<String> getUpperSectionCombos(User user){
        ArrayList<String> upperSectionCombos = new ArrayList<>();

        for (String key : user.getUpperSectionCombos()){
            upperSectionCombos.add(key);
        }
        return upperSectionCombos;
    }
    private ArrayList<String> getLowerSectionCombos(User user){
        ArrayList<String> lowerSectionCombos = new ArrayList<>();

        for (String key : user.getLowerSectionKeySet()){
            lowerSectionCombos.add(key);
        }
        return lowerSectionCombos;
    }
    private ArrayList<Rectangle> randomizeDie(){
        return controller.getDie();
    }
    private HBox renderDie(ArrayList<Rectangle> die){
        HBox result = new HBox(5);
        for (Rectangle dice : die){
            result.getChildren().add(dice);
        }
        return result;
    }
}
