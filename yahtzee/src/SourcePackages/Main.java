package SourcePackages;

import SourcePackages.controller.Menu;
import SourcePackages.view.MenuScene;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Heron on 5/2/2017.
 */
public class Main extends Application{
    Stage window;

    int totalUserScore = 0;
    int totalComputerScore = 0;
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        new Menu(window);

        window.setOnCloseRequest( e ->{
            window.close();
        });
        window.show();
    }
}
