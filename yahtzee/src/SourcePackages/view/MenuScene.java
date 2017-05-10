package SourcePackages.view;

import SourcePackages.controller.Game;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Heron on 5/8/2017.
 */
public class MenuScene {
    public MenuScene(Stage window) {
        //menu
        Label w = new Label("Welcome");
        w.setAlignment(Pos.CENTER);

        Label t = new Label("to");
        t.setAlignment(Pos.CENTER);

        Label h = new Label("Ha-yahtzee");
        h.setAlignment(Pos.CENTER);

        Button start = new Button("Start!");
        start.setOnAction(e -> {
            new Game(window);
        });


        //layouts
        VBox welcomeTextContainer = new VBox(5);
        welcomeTextContainer.getChildren().addAll(w, t, h);
        welcomeTextContainer.setAlignment(Pos.CENTER);

        StackPane sp = new StackPane();
        sp.getChildren().add(start);

        BorderPane bp = new BorderPane();
        bp.setTop(welcomeTextContainer);
        bp.setCenter(sp);

        Scene scene = new Scene(bp, 400, 400);

        window.setScene(scene);
    }
}
