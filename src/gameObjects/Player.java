package gameObjects;

import graphics.Assets;
import input.Keyboard;
import math.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Player extends MovingObject {

    private Vector2D heading;
    public Player(Vector2D position, Vector2D velocitiy, BufferedImage texture) {
        super(position, velocitiy, texture);
        heading = new Vector2D(0, 1);
    }

    @Override
    public void update() {

        if(Keyboard.RIGHT)
            angle += Math.PI/20;
        if(Keyboard.LEFT)
            angle -= Math.PI/20;
        heading = heading.setDirection(angle - Math.PI/2);

    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        at = AffineTransform.getTranslateInstance(position.getX(),position.getY());
        at.rotate(angle, Assets.player.getWidth()/2, Assets.player.getHeight()/2);
        g2d.drawImage(Assets.player, at, null);
    }
}
