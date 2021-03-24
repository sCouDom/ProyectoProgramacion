package gameObjects;

import graphics.Assets;

import java.awt.image.BufferedImage;

public enum Zom {

    ZOMBIE(Assets.zombie);

    public BufferedImage textura;

    private Zom(BufferedImage texture){
        this.textura = texture;
    }
}
