package com.gax.Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Author: Gác Xanh (phamanh)
 * Date: 19/12/2015
 * Class: OOP2
 * Project: 2048
 */
public class Square extends Sprite {
    private int value = 2;
    private final double sizeSquare = 57.0;

    public void setValue(int value) {
        this.value = value * 2;
    }

    public Square(int x, int y) {
        try {
            this.image = new Image(new FileInputStream("res/2.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.position = new Vector2D(30 + x * 67, 165 + y * 67);
        this.size = new Size(sizeSquare);
    }
}
