package SourcePackages.controller;

import SourcePackages.Game;
import SourcePackages.view.MenuScene;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Heron on 5/8/2017.
 */
public class MenuController {
    Stage window;
    MenuScene view;
    public MenuController(Stage window){
        this.window = window;
        this.initScene();
    }

    private void initScene(){
        this.view = new MenuScene(this.window,this);
    }
    public void handleStartButton(String usersName){
        new Game(window,usersName);
    }
}
