package gameObjects;

import matematica.Vector;

import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * Definición de atributos y métodos básicos de objetos.
 */
public abstract class Objetos {

    protected BufferedImage textura;
    protected Vector posicion;
    /**
     * Constructor de Objetos.
     * @param posicion
     * @param textura
     */
    public Objetos(Vector posicion, BufferedImage textura){
        this.posicion = posicion;
        this.textura = textura;
    }

    public abstract void update();

    public abstract void draw(Graphics g);

    /**
     * Getters y setters
     * @return
     */
    public Vector getPosicion() {
        return posicion;
    }

    public void setPosicion(Vector posicion) {
        this.posicion = posicion;
    }
}
