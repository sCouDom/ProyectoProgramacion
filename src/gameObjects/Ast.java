package gameObjects;

import graphics.Assets;

import java.awt.image.BufferedImage;

public enum Ast {

    BIG(Assets.asteroide);

    public BufferedImage textures;

    private Ast(BufferedImage texture){
        this.textures = texture;
    }
}
