package gameObjects;

import matematica.Vector;
import estados.Estado;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
/**
 * Clase que permite a los objetos moverse y interactuar entre ellos.
 */
public abstract class ObjetosMovimiento extends Objetos {

    protected Vector velocidad;
    protected AffineTransform at;
    protected double angulo;
    protected double velocidadMaxima;
    protected int ancho;
    protected int altura;
    protected Estado estado;
    /**
     * Constructor de la clase ObjetosMovimiento.
     * @param posicion
     * @param velocidad
     * @param velocidadMaxima
     * @param textura
     * @param estado
     */
    public ObjetosMovimiento(Vector posicion, Vector velocidad, double velocidadMaxima, BufferedImage textura, Estado estado){
        super(posicion, textura);
        this.velocidad = velocidad;
        this.velocidadMaxima = velocidadMaxima;
        this.estado = estado;
        ancho = textura.getWidth();
        altura = textura.getHeight();
        angulo = 0;
    }
    /**
     * Método que se encarga de comprobar las colisiones de objetos.
     * @return
     */
    protected boolean colisionCon(){
        ArrayList<ObjetosMovimiento> objetosMovimientos = estado.getObjetoMovimiento();
        boolean flag = false;
        for (int i = 0; i < objetosMovimientos.size(); i++) {
            ObjetosMovimiento m = objetosMovimientos.get(i);
            if(m.equals(this))
                continue;
            double distance = m.getCentro().restar(getCentro()).getMagnitud();
            if(distance<m.ancho /2 + ancho /2 && objetosMovimientos.contains(this)){
                colisionObjetos(m, this);
                flag = true;
            }
        }
        return flag;
    }
    /**
     * Método que comprueba que los dos objetos no sean zombies.
     * @param a
     * @param b
     */
    private void colisionObjetos(ObjetosMovimiento a, ObjetosMovimiento b){
        if( !(a instanceof Zombie) || !(b instanceof Zombie)){
            a.destruir();
            b.destruir();
        }
    }
    /**
     * Método que destruye objetos.
     */
    protected void destruir(){
        estado.getObjetoMovimiento().remove(this);
    }

    /**
     * Método utilizado para obtener el centro del sprite.
     * @return
     */
    protected Vector getCentro(){
        return new Vector(posicion.getX() + ancho /2, posicion.getY() + altura /2);
    }
}
