package states;

import gameObjects.Ast;
import gameObjects.Asteroide;
import gameObjects.MovingObject;
import gameObjects.Player;
import graphics.Assets;
import math.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameState {

    private Player player;
    private ArrayList<MovingObject> movingObject = new ArrayList<MovingObject>();

    private int numAsteroides;

    public GameState(){
        player = new Player(new Vector2D(100,500), new Vector2D(), 4, Assets.player, this);
        movingObject.add(player);
        numAsteroides = 1;
        startWave();

    }

    public void startWave(){
        double x, y;
        for (int i = 0; i < numAsteroides; i++) {
            x = i % 2 == 0 ? Math.random()*1000+200 : 0;
            y = i % 2 != 0 ? Math.random()*800+200 : 0;

            BufferedImage texture = Assets.asteroide;

            movingObject.add(new Asteroide(
                    new Vector2D(x, y),
                    new Vector2D(0,1).setDirection(Math.random()*Math.PI*2),
                    2,
                    texture,
                    this,
                    Ast.BIG
                    ));
        }
        numAsteroides++;
    }

    public void update(){
        for (int i = 0; i < movingObject.size(); i++) {
            movingObject.get(i).update();
        }
    }

    public void draw(Graphics g) {
        for (int i = 0; i < movingObject.size(); i++) {
            movingObject.get(i).draw(g);
        }
    }

    public ArrayList<MovingObject> getMovingObject(){
        return movingObject;
    }

}
