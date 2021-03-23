package gameObjects;

import graphics.Assets;
import input.Keyboard;
import math.Vector2D;
import states.GameState;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Player extends MovingObject {

    private Vector2D heading;
    private Vector2D acceleration;
    private final double ACC = 0.2;


    public Player(Vector2D position, Vector2D velocitiy, double maxVel, BufferedImage texture, GameState gameState) {
        super(position, velocitiy, maxVel, texture, gameState);
        heading = new Vector2D(0, 1);
        acceleration = new Vector2D();
    }

    @Override
    public void update() {

        if(Keyboard.RIGHT)
            angle += Math.PI/20;
        if(Keyboard.LEFT)
            angle -= Math.PI/20;
        heading = heading.setDirection(angle - Math.PI/2);

        position = position.add(velocity);

        if(Keyboard.UP){
            acceleration = heading.scale(ACC);
        } else {

        }
        velocity = velocity.add(acceleration);
        velocity.limit(maxVel);


    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        at = AffineTransform.getTranslateInstance(position.getX(),position.getY());
        at.rotate(angle, width/2, height/2);
        g2d.drawImage(Assets.player, at, null);
    }

    public Vector2D getCenter(){
        return new Vector2D(position.getX() + width/2, position.getY() + height/2);
    }
}
