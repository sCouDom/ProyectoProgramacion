package gameObjects;

import math.Vector2D;
import states.GameState;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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

    protected boolean collidesWith(){
        ArrayList<MovingObject> movingObjects = gameState.getMovingObject();
        boolean flag = false;

        for (int i = 0; i < movingObjects.size(); i++) {
            MovingObject m = movingObjects.get(i);
            if(m.equals(this))
                continue;

            double distance = m.getCenter().substract(getCenter()).getMagnitude();
            if(distance<m.width/2+width/2 && movingObjects.contains(this)){
                objectCollision(m, this);
                flag = true;
            }

        }
        return flag;
    }

    private void objectCollision(MovingObject a, MovingObject b){
        if( !(a instanceof Asteroide) || !(b instanceof Asteroide)){
            a.destroy();
            b.destroy();
        }

    }

    protected void destroy(){
        gameState.getMovingObject().remove(this);
    }

    protected Vector2D getCenter(){
        return new Vector2D(position.getX() + width/2, position.getY() + height/2);
    }
}
