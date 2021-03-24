package gameObjects;

import graphics.Assets;
import matematica.Vector;
import estados.Estado;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Zombie extends ObjetosMovimiento {

    private Zom zom;

    public Zombie(Vector position, Vector velocitiy, double maxVel, BufferedImage texture, Estado estado, Zom zom) {
        super(position, velocitiy, maxVel, texture, estado);
        this.zom = zom;
    }

    @Override
    public void update() {
        posicion = posicion.sumar(velocidad);
        if(posicion.getX()>800)
            posicion.setX(0);
        if(posicion.getY()>500)
            posicion.setY(0);
        if(posicion.getX()<0)
            posicion.setX(800);
        if(posicion.getY()<0)
            posicion.setY(500);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        at = AffineTransform.getTranslateInstance(posicion.getX(), posicion.getY());
        g2d.drawImage(Assets.zombie, at, null);
    }

    public Zom getZom() {
        return zom;
    }
}
