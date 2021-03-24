package gameObjects;

import graphics.Assets;
import input.Keyboard;
import math.Vector2D;
import states.GameState;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Player extends MovingObject {

    private Vector2D heading;
    private Vector2D acceleration;
    private final double ACC = 0.2;
    private int points = 0;


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
        points +=1;
        if (collidesWith()){
            ArrayList<Integer> l = new ArrayList<Integer>();
            try{
                File f = new File("src/registro.txt");
                Scanner sf = new Scanner(f);
                while(sf.hasNext()){
                    String temp = sf.next();
                    if (temp.compareToIgnoreCase("Partida")==0)
                        continue;
                    else
                        if(Integer.parseInt(temp)>=10)
                            l.add(Integer.parseInt(temp));
                }
                sf.close();
                System.out.println(l.size());

                FileWriter fw = new FileWriter("src/registro.txt");
                l.add(points);
                for (int i = 0; i < l.size(); i++) {
                    fw.write("\nPartida "+i+"\n"+String.valueOf(l.get(i)));
                }
                fw.close();
                System.exit(0);
            }catch(FileNotFoundException e){
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        at = AffineTransform.getTranslateInstance(position.getX(),position.getY());
        at.rotate(angle, width/2, height/2);
        g2d.drawImage(Assets.player, at, null);
        g.setColor(Color.white);
        g.drawString(String.valueOf(points), 25, 25);
    }

    public Vector2D getCenter(){
        return new Vector2D(position.getX() + width/2, position.getY() + height/2);
    }
}
