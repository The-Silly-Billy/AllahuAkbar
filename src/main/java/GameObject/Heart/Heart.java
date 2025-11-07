package GameObject.Heart;

import GameObject.GameObject;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Heart extends GameObject {
    GamePanel gp;
    BufferedImage image;

    public Heart (GamePanel gp,int posX){
        this.gp = gp;
        this.posX = posX;
        this.posY = gp.screenHeight - 50;

        width = 22;
        height = 22;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Heart.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}