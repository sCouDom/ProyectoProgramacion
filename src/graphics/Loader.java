package graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Loader {
    public static BufferedImage imageLoader(String path){
        try {
            System.out.println(Loader.class.getResource(path));
            return ImageIO.read(Loader.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
