package graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
/**
 * Clase que carga en la memoria las imagenes.
 */
public class CargadorAssets {
    /**
     * Método utilizado para leer los sprites.
     * @param path
     * @return
     */
    public static BufferedImage cargadorImagen(String path){
        try {
            return ImageIO.read(CargadorAssets.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
