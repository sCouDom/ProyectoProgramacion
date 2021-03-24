package estados;

import gameObjects.Zom;
import gameObjects.Zombie;
import gameObjects.ObjetosMovimiento;
import gameObjects.Jugador;
import graphics.Assets;
import matematica.Vector;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Estado {

    private Jugador jugador;
    private ArrayList<ObjetosMovimiento> objetosMovimiento = new ArrayList<ObjetosMovimiento>();

    private int numZombies;

    public Estado(){
        jugador = new Jugador(new Vector(100,500), new Vector(), 4, Assets.jugador, this);
        objetosMovimiento.add(jugador);
        numZombies = 1;
        startWave();

    }

    public void startWave(){
        double x, y;
        for (int i = 0; i < numZombies; i++) {
            x = i % 2 == 0 ? Math.random()*1000+200 : 0;
            y = i % 2 != 0 ? Math.random()*800+200 : 0;

            BufferedImage texture = Assets.zombie;

            objetosMovimiento.add(new Zombie(
                    new Vector(x, y),
                    new Vector(0,1).setDireccion(Math.random()*Math.PI*2),
                    2,
                    texture,
                    this,
                    Zom.ZOMBIE
                    ));
        }
        numZombies++;
    }

    public void update(){
        for (int i = 0; i < objetosMovimiento.size(); i++) {
            objetosMovimiento.get(i).update();
        }
    }

    public void draw(Graphics g) {
        for (int i = 0; i < objetosMovimiento.size(); i++) {
            objetosMovimiento.get(i).draw(g);
        }
    }

    public ArrayList<ObjetosMovimiento> getMovingObject(){
        return objetosMovimiento;
    }

}
