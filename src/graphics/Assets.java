package graphics;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage jugador;
    public static BufferedImage zombie;

    public static void init(){
        jugador = CargadorAssets.cargadorImagen("/imagenes/Audi.png");
        zombie = CargadorAssets.cargadorImagen("/imagenes/skeleton-attack_8.png");

    }
}
