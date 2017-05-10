package SourcePackages.controller;

import SourcePackages.view.MenuScene;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Heron on 5/8/2017.
 */
public class Menu {
    Stage window;
    MenuScene view;
    public Menu(Stage window){
        this.window = window;
        this.initScene();
    }

    private void initScene(){
        this.view = new MenuScene(this.window);
    }
}
