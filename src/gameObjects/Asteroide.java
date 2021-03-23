package gameObjects;

import graphics.Assets;
import math.Vector2D;
import states.GameState;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Asteroide extends MovingObject {

    private Ast ast;

    public Asteroide(Vector2D position, Vector2D velocitiy, double maxVel, BufferedImage texture, GameState gameState, Ast ast) {
        super(position, velocitiy, maxVel, texture, gameState);
        this.ast = ast;
    }

    @Override
    public void update() {
        position = position.add(velocity);
        angle += 0.01;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        at = AffineTransform.getTranslateInstance(position.getX(),position.getY());
        at.rotate(angle, width/2, height/2);
        g2d.drawImage(Assets.asteroide, at, null);
    }

    public Ast getAst() {
        return ast;
    }
}
