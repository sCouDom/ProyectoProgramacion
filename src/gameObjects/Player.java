package gameObjects;

import input.Keyboard;
import math.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {

    public Player(Vector2D position, BufferedImage texture){
        super(position, texture);
    }

    @Override
    public void update() {
        if(Keyboard.RIGHT){
            position.setX(position.getX()+1);
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(texture, (int)position.getX(), (int)position.getY(), null);
    }
}
