package com.gax;

import com.gax.Scene.GameScene;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameViewController extends Application {

    GameScene gameScene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("2048");
        gameScene = new GameScene();
        primaryStage.setScene(gameScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
