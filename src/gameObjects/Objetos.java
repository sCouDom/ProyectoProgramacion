package gameObjects;

import matematica.Vector;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Objetos {

    protected BufferedImage textura;
    protected Vector posicion;

    public Objetos(Vector posicion, BufferedImage textura){
        this.posicion = posicion;
        this.textura = textura;
    }

    public abstract void update();

    public abstract void draw(Graphics g);

    public Vector getPosicion() {
        return posicion;
    }

    public void setPosicion(Vector posicion) {
        this.posicion = posicion;
    }
}
