package graphics;

import java.awt.image.BufferedImage;
/**
 * Clase que carga las imágenes de los objetos
 */
public class Assets {

    public static BufferedImage jugador;
    public static BufferedImage zombie;
    /**
     * Método encargado de cargar las imagenes
     * del jugador y los zombies.
     */
    public static void init(){
        jugador = CargadorAssets.cargadorImagen("/imagenes/Audi.png");
        zombie = CargadorAssets.cargadorImagen("/imagenes/skeleton-attack_8.png");

    }
}
