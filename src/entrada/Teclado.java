package entrada;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * Clase encargada de registrar las entradas del teclado
 */
public class Teclado implements KeyListener {

    private boolean[] keys = new boolean[256];
    public static boolean UP, LEFT, RIGHT;
    /**
     * Constructor de la clase Teclado.
     */
    public Teclado(){
        UP = false;
        LEFT = false;
        RIGHT = false;
    }
    /**
     * Método encargado de comprobar si las teclas UP,LEFT y RIGHT están pulsadas o no.
     */
    public void update(){
        UP = keys[KeyEvent.VK_UP];
        LEFT = keys[KeyEvent.VK_LEFT];
        RIGHT = keys[KeyEvent.VK_RIGHT];
    }
    /**
     * Método que registra cuando se pulsa una tecla.
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }
    /**
     * Método que registra cuando se suelta una tecla.
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
    /**
     * Método vacío porque no se utiliza pero
     * es necesario hacer el Override.
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }
}
