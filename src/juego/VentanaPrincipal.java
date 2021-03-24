package juego;

import graphics.Assets;
import entrada.Teclado;
import estados.Estado;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Clase que gestiona el funcionamiento básico
 * del programa
 */
public class VentanaPrincipal extends JFrame implements Runnable{

    public static final int ANCHO = 1000, ALTURA =600;
    private Canvas lienzo;
    private Thread hilo;
    private boolean funcionando =false;
    private BufferStrategy bs;
    private Graphics g;
    private final int FPS = 60;
    private double TIEMPO_OBJETIVO = 1000000000/FPS;
    private double delta = 0;
    private int MEDIAFPS = FPS;
    private Estado estado;
    private Teclado teclado;
    /**
     * Inicializa los parametros generales: titulo, tamaño y posicion de la ventana.
     * Inicializa el canvas y el teclado, permite que reciba entradas por parte del teclado
     * y los añade a la ventana.
     */
    public VentanaPrincipal(){
        setTitle("Esquívalo como puedas");
        setSize(ANCHO, ALTURA);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);


        lienzo = new Canvas();
        teclado = new Teclado();
        lienzo.setPreferredSize(new Dimension(ANCHO, ALTURA));
        lienzo.setMinimumSize(new Dimension(ANCHO, ALTURA));
        lienzo.setMaximumSize(new Dimension(ANCHO, ALTURA));
        lienzo.setFocusable(true);
        add(lienzo);
        lienzo.addKeyListener(teclado);
        setVisible(true);
    }

    /**
     * Método principal de la aplicación, crea la ventana.
     * e inicia el funcionamiento del juego
     * @param args
     */
    public static void main(String[] args) {
        new VentanaPrincipal().start();
    }
    /**
     * Método para actualizar los objetos.
     */
    private void update(){
        teclado.update();
        estado.update();
    }
    /**
     * Método para dibujar los objetos.
     */
    private void draw(){
        bs= lienzo.getBufferStrategy();
        if(bs==null){
            lienzo.createBufferStrategy(3);
            return;
        }
        g=bs.getDrawGraphics();
        //----------------------
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, ANCHO, ALTURA);
        estado.draw(g);
        g.drawString(""+ MEDIAFPS, 10, 10);
        //---------------------
        g.dispose();
        bs.show();
    }
    /**
     * Método para cambiar el estado del juego a iniciado.
     */
    private void init(){
        Assets.init();
        estado =new Estado();
    }
    /**
     * Bucle principal del juego. Método que limita los FPS del juego a 60.
     */
    @Override
    public void run(){
        long ahora = 0;
        long lastTime = System.nanoTime();
        int frames = 0;
        long tiempo = 0;

        init();

        while(funcionando){
            ahora = System.nanoTime();
            delta += (ahora-lastTime)/ TIEMPO_OBJETIVO;
            tiempo += (ahora-lastTime);
            lastTime=ahora;

            if(delta>=1){
                update();
                draw();
                delta--;
                frames++;
            }
            if(tiempo>=1000000000){
                MEDIAFPS = frames;
                frames = 0;
                tiempo = 0;
            }
        }
        stop();
    }
    /**
     * Método para iniciar el hilo.
     */
    public void start(){
        hilo = new Thread(this);
        hilo.start();
        funcionando =true;
    }
    /**
     * Método para parar el hilo.
     */
    public void stop(){
        try {
            hilo.join();
            funcionando =false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
