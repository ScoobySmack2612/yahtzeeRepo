package SourcePackages.view;

import SourcePackages.controller.MenuController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Heron on 5/8/2017.
 */
public class MenuScene {
    Stage window;
    boolean usernameEntered = false;
    String username;
    MenuController controller;
    public MenuScene(Stage window, MenuController controller) {
        this.controller = controller;
        this.window = window;
        //menu
        Label w = new Label("Welcome");
        w.setAlignment(Pos.CENTER);

        Label t = new Label("to");
        t.setAlignment(Pos.CENTER);

        Label h = new Label("Ha-yahtzee");
        h.setAlignment(Pos.CENTER);

        VBox vb = getCenterContent();

        //layouts
        VBox welcomeTextContainer = new VBox(5);
        welcomeTextContainer.getChildren().addAll(w, t, h);
        welcomeTextContainer.setAlignment(Pos.CENTER);

        BorderPane bp = new BorderPane();
        bp.setTop(welcomeTextContainer);
        bp.setCenter(vb);

        Scene scene = new Scene(bp, 400, 400);

        window.setScene(scene);
    }
    private VBox getCenterContent(){
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        if(!usernameEntered) {
            TextField tf = new TextField();
            Button btn = new Button("Submit Name");
            btn.setOnAction(e -> {
                username = tf.getText();
                usernameEntered = true;
                getCenterContent();
                vb.getChildren().clear();
                Button go = new Button("Let's Play");
                go.setOnAction(ex -> {
                    controller.handleStartButton(username);
                });
                vb.getChildren().add(go);
            });
            vb.getChildren().addAll(tf,btn);
        }
        return vb;
    }
}
