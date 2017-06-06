package SourcePackages.view;

import SourcePackages.controller.GameController;
import SourcePackages.controller.SubControllers.Scoring;
import SourcePackages.model.User;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Created by Heron on 5/8/2017.
 */

public class GameScene {
    Stage window;
    User[] users;
    Scene scene;
    GameController controller;
    Button roll,play;
    ImagePattern[] dieImages = {new ImagePattern(new Image(getClass().getResource("../img/d1.png").toExternalForm())),new ImagePattern(new Image(getClass().getResource("../img/d2.png").toExternalForm())),new ImagePattern(new Image(getClass().getResource("../img/d3.png").toExternalForm())),new ImagePattern(new Image(getClass().getResource("../img/d4.png").toExternalForm())),new ImagePattern(new Image(getClass().getResource("../img/d5.png").toExternalForm())),new ImagePattern(new Image(getClass().getResource("../img/d6.png").toExternalForm()))};
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
        HBox input = this.getInputOptions();
        input.setAlignment(Pos.CENTER);
        HBox diceSection = this.renderDie();

        VBox inAndDie = new VBox();
        inAndDie.getChildren().addAll(diceSection,input);

        bp.setCenter(scorecards);
        bp.setBottom(inAndDie);

        window.setScene(scene);
    }
    private VBox createScoreCard(User user){
        scene.getStylesheets().add(getClass().getResource("../css/gamescene.css").toExternalForm());

        VBox result = new VBox();
        result.setId(user.getName());
        result.setPadding(new Insets(0,25,0,25));
        result.setStyle("-fx-font-size: 16;");

        Label userInfo = new Label(user.getName()+": 0");
        userInfo.setPadding(new Insets(0,0,10,0));
        userInfo.setAlignment(Pos.CENTER);
        result.getChildren().addAll(userInfo);

        IntegerProperty scoreLabel = new SimpleIntegerProperty(0);
        IntegerProperty usersScore = controller.getUserScore(user);
        scoreLabel.bind(usersScore);
        usersScore.addListener( ( ((observable, oldValue, newValue) -> {
            userInfo.setText(user.getName()+": "+Integer.toString(usersScore.getValue()));
        })));

        VBox sections = new VBox();

        Label upper = new Label("Upper Section");
        Label lower = new Label("Lower Section");

        sections.getChildren().add(upper);

        String[] upperSectionCombos = user.getUpperSectionCombos();

        for (String combo : upperSectionCombos){
            Label comboName = new Label(combo);
            Label scoreForCombo = new Label("  ");
            scoreForCombo.setId(combo);

            StringProperty scoreModel = user.getScoreToBind(upper.getText(),combo);
            Bindings.bindBidirectional( scoreForCombo.textProperty(), scoreModel );

            scoreForCombo.getStyleClass().add("scorebox");
            scoreForCombo.setPrefSize(20,20);

            BooleanProperty isScoreToEnter = new SimpleBooleanProperty(false);
            scoreForCombo.setOnMouseEntered(e -> {
                if (scoreForCombo.getText().equals("  ")) {
                    scoreForCombo.setText(Integer.toString(controller.getScoreForCombo(scoreForCombo.getId())));
                }
            });
            scoreForCombo.setOnMouseExited(e -> {
                if (!isScoreToEnter.getValue()){
                    scoreForCombo.setText("  ");
                }
            });
            scoreForCombo.setOnMouseClicked(e -> {
                isScoreToEnter.set(true);
                String[] sectionAndCombo = {upper.getText(), scoreForCombo.getId()};
                controller.setComboToScore(sectionAndCombo);
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

        String[] lowerSectionCombos = user.getLowerSectionCombos();
        for (String combo : lowerSectionCombos){
            Label comboName = new Label(combo);

            Label scoreForCombo = new Label();
            scoreForCombo.getStyleClass().add("scorebox");
            scoreForCombo.setId(combo);
            StringProperty scoreModel = user.getScoreToBind(lower.getText(),combo);
            Bindings.bindBidirectional( scoreForCombo.textProperty(), scoreModel );

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

            BooleanProperty isScoreToEnter = new SimpleBooleanProperty(false);
            scoreForCombo.setOnMouseEntered(e -> {
                if (scoreForCombo.getText().equals("  ")) {
                    scoreForCombo.setText(Integer.toString(controller.getScoreForCombo(scoreForCombo.getId())));
                }
            });
            scoreForCombo.setOnMouseExited(e -> {
                if (!isScoreToEnter.getValue()){
                    scoreForCombo.setText("  ");
                }
            });
            scoreForCombo.setOnMouseClicked(e -> {
                isScoreToEnter.set(true);
                scoreForCombo.setText(Integer.toString(controller.getScoreForCombo(scoreForCombo.getId())));
                String[] sectionAndCombo = {lower.getText(), scoreForCombo.getId()};
                controller.setComboToScore(sectionAndCombo);
            });
        }
        result.getChildren().add(sections);
        return result;

    }
    private HBox renderDie(){
        HBox result = new HBox(5);
        result.setAlignment(Pos.CENTER);

        for (int x = 0; x <= 4; x++){
            Rectangle die = this.getDie(x);

            result.getChildren().add(die);
        }

        return result;
    }
    private Rectangle getDie(int x){
        Rectangle die = new Rectangle(50,50);
        die.setArcHeight(22);
        die.setArcWidth(22);

        IntegerProperty dieRollValue = controller.getDiceToBind(x);
        IntegerProperty dieImgValue = new SimpleIntegerProperty(dieRollValue.getValue());

        Bindings.bindBidirectional(dieImgValue, dieRollValue);
        dieRollValue.addListener(((observable, oldValue, newValue) -> {
            die.setFill(dieImages[dieImgValue.getValue()-1]);
            die.setId(Integer.toString(x));
        }));

        die.setId(Integer.toString(x));

        die.setOnMouseClicked(e ->{
            controller.dieClicked(die);
        });

        die.setFill(dieImages[dieImgValue.getValue()-1]);

        return die;
    }
    private HBox getInputOptions(){
        HBox result = new HBox();
        roll = new Button("Roll Again");
        roll.setOnAction(e->{
            controller.rollDice();
            if (controller.isTurnOver()){
                play.setVisible(false);
                roll.setVisible(false);
            }
        });
        play = new Button("Enter Score");
        play.setOnAction(e -> {
            controller.enterScore(users[0]);
            controller.setTurnFinished();
            play.setVisible(false);
            roll.setVisible(false);
        });
        result.getChildren().addAll(roll,play);
        return result;
    }
    public void showUserTurnElements(){
        this.roll.setVisible(true);
        this.play.setVisible(true);
    }
}
