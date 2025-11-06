package GameObject.Brick;

import GameObject.*;
import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Brick extends GameObject {

    GamePanel gp;
    int hitPoints;
    public BufferedImage image;
    boolean isWall = false;

    public Brick(GamePanel gp) {
        this.gp = gp;

        width = gp.originalTileSize * 3;                //48
        height = gp.originalTileSize * 2 - 7;           //25
    }

    public void takeHit(Ball ball) {
        hitPoints -= ball.ballDamage;
    }

    public boolean isDestroy() {
        if (!isWall && hitPoints <= 0) {
            return true;
        }
        return false;
    }
}
