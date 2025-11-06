package GameObject;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Heart extends GameObject{
    GamePanel gp;
    BufferedImage image;

    public Heart (GamePanel gp,int posX,int posY){
        this.gp=gp;
        this.posX=posX;
        this.posY=posY;

        width = 22;
        height = 22;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Heart.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics2D g2) {
        g2.drawImage(image, (int) posX ,  (int) posY , width, height, null);
    }


}