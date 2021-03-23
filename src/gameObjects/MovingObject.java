package gameObjects;

import math.Vector2D;
import states.GameState;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public abstract class MovingObject extends GameObject{

    protected Vector2D velocity;
    protected AffineTransform at;
    protected double angle;
    protected double maxVel;
    protected int width;
    protected int height;
    protected GameState gameState;

    public MovingObject(Vector2D position, Vector2D velocitiy, double maxVel, BufferedImage texture, GameState gameState){
        super(position, texture);
        this.velocity = velocitiy;
        this.maxVel = maxVel;
        this.gameState=gameState;
        width = texture.getWidth();
        height = texture.getHeight();
        angle = 0;
    }
}
