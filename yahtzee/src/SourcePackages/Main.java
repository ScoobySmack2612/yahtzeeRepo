package SourcePackages;

import SourcePackages.controller.MenuController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Heron on 5/2/2017.
 */
public class Main extends Application{
    Stage window;
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        new MenuController(window);

        window.setOnCloseRequest( e ->{
            window.close();
        });
        window.show();
    }
}
