package gameObjects;

import graphics.Assets;

import java.awt.image.BufferedImage;

/**
 * Enum que asocia la imagen de los zombies.
 */
public enum Zom {

    ZOMBIE(Assets.zombie);

    public BufferedImage textura;

    private Zom(BufferedImage texture){
        this.textura = texture;
    }
}
