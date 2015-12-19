package com.gax.Model;

import com.gax.Config.Config;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Author: Gác Xanh (phamanh)
 * Date: 19/12/2015
 * Class: OOP2
 * Project: 2048
 */
public class Sprite {
    public Vector2D position;
    public Size size;

    protected Image image;

    public Sprite(String imageNamed) {
        try {
            this.image = new Image(new FileInputStream(imageNamed));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.position = Vector2D.zero;
        this.size = new Size(this.image.getWidth(), this.image.getHeight());
    }

    public Sprite(){}

    public void render(GraphicsContext gc) {
        gc.drawImage(this.image, position.x, position.y, size.width, size.height);
    }
}
