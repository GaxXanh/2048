package com.gax.Scene;

import com.gax.Config.Config;
import com.gax.Helper.Utility;
import com.gax.Model.Size;
import com.gax.Model.Sprite;
import com.gax.Model.Square;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Gác Xanh (phamanh)
 * Date: 19/12/2015
 * Class: OOP2
 * Project: 2048
 */
public class GameScene extends Scene {
    public Group root;
    public Canvas canvas;
    AnimationTimer mainLoopManager;
    Sprite background;

    Square[][] squareMatrix;

    public GameScene() {
        super(new Group());
        setupGameLoop();
        newLevel();
    }

    private void newLevel() {
        background = new Sprite("res/1.png");
        background.size = new Size(Config.WindowProperties.WINDOW_WIDTH, Config.WindowProperties.WINDOW_HEIGHT);
        Utility.randomSquare();
    }

    private void setupGameLoop() {
        this.root = (Group) super.getRoot();
        this.canvas = new Canvas(Config.WindowProperties.WINDOW_WIDTH, Config.WindowProperties.WINDOW_HEIGHT);
        root.getChildren().add(canvas);
        ArrayList<String> input = new ArrayList<>();
        this.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String code = e.getCode().toString();

                        // only add once... prevent duplicates
                        if (!input.contains(code))
                            input.add(code);
                    }
                });

        this.setOnKeyReleased(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String code = e.getCode().toString();
                        input.remove(code);
                    }
                });
        mainLoopManager = new AnimationTimer() {

            @Override
            public void handle(long currentTime) {
                handleEvents(input);
                update(currentTime);
                render(canvas.getGraphicsContext2D());
            }
        };
        mainLoopManager.start();
    }

    public void handleEvents(List<String> input) {
        if (input.contains("LEFT")){
            Utility.randomSquare();
            input.remove("LEFT");
        }
    }

    public void update(long currentTime) {
        squareMatrix = Square.getSquareMatrix();
    }

    public void render(GraphicsContext gc) {
        // clear canvas
        gc.clearRect(0, 0, Config.WindowProperties.WINDOW_WIDTH, Config.WindowProperties.WINDOW_HEIGHT);
        background.render(gc);
        for (Square[] aSquareMatrix : squareMatrix) {
            for (int j = 0; j < squareMatrix[1].length; j++) {
                if (aSquareMatrix[j].isActive()) {
                    aSquareMatrix[j].render(gc);
                }
            }
        }
    }

}
