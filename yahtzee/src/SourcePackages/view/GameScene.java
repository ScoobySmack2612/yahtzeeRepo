package SourcePackages.view;

import SourcePackages.model.User;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by Heron on 5/8/2017.
 */
public class GameScene {
    Stage window;
    User[] users;
    public GameScene(Stage window, User[] users){
        this.window = window;
        this.users = users;
        this.initScene();
    }
    private void initScene(){
        for (User user : users){
            GridPane scoreCard = this.createScoreCard(user);
        }
    }
    private GridPane createScoreCard(User user){
        GridPane result = new GridPane();
        result.setPrefSize(400,400);

        Label name = new Label(user.getName()+user.getScoreAsString());
        result.add(name, 1,1,4,2);

        return result;

    }
}
