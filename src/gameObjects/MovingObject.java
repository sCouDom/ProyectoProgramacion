package gameObjects;

import math.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public abstract class MovingObject extends GameObject{

    protected Vector2D velocity;
    protected AffineTransform at;
    protected double angle;
    protected double maxVel;

    public MovingObject(Vector2D position, Vector2D velocitiy, double maxVel, BufferedImage texture){
        super(position, texture);
        this.velocity = velocitiy;
        this.maxVel = maxVel;
        angle = 0;
    }
}
