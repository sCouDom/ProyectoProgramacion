package gameObjects;

import graphics.Assets;
import entrada.Teclado;
import matematica.Vector;
import estados.Estado;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Jugador extends ObjetosMovimiento {

    private Vector direccion;
    private Vector aceleracion;
    private final double ACEL = 0.2;
    private int points = 0;


    public Jugador(Vector posicion, Vector velocidad, double velocidadMaxima, BufferedImage textura, Estado estado) {
        super(posicion, velocidad, velocidadMaxima, textura, estado);
        direccion = new Vector(0, 1);
        aceleracion = new Vector();
    }

    @Override
    public void update() {

        if(Teclado.RIGHT)
            angulo += Math.PI/20;
        if(Teclado.LEFT)
            angulo -= Math.PI/20;
        direccion = direccion.setDireccion(angulo - Math.PI/2);

        posicion = posicion.sumar(velocidad);

        if(Teclado.UP){
            aceleracion = direccion.porEscalar(ACEL);
        } else {

        }
        velocidad = velocidad.sumar(aceleracion);
        velocidad.limitar(velocidadMaxima);
        points +=1;
        if (colisionCon()){
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
        at = AffineTransform.getTranslateInstance(posicion.getX(), posicion.getY());
        at.rotate(angulo, ancho /2, altura /2);
        g2d.drawImage(Assets.jugador, at, null);
        g.setColor(Color.white);
        g.drawString(String.valueOf(points), 25, 25);
    }

    public Vector getCentro(){
        return new Vector(posicion.getX() + ancho /2, posicion.getY() + altura /2);
    }
}
