package graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CargadorAssets {
    public static BufferedImage cargadorImagen(String path){
        try {
            return ImageIO.read(CargadorAssets.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
