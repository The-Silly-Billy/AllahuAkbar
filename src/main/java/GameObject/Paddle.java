package GameObject;

import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Paddle extends GameObject {

    GamePanel gp;
    KeyHandler keyH;
    BufferedImage image;

    public Paddle(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        width = gp.originalTileSize * 5 - 10;               //70
        height = gp.originalTileSize;                       //16

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Paddle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        initPos();
    }

    public void initPos() {
        posX = (double) (gp.screenWidth - width) / 2;
        posY = (double) gp.screenHeight - 150;

        speed = 4;
    }

    public void update() {
        if(keyH.rightPressed) {
            posX += speed;
        }
        if(keyH.leftPressed) {
            posX -= speed;
        }
        // ra khoi man hinh trai thi co hieu ung dung yen
        if(posX < 0) {
            posX = 0;
        }
        //ra khoi man hinh ben phai thi co hieu ung dung yen
        if(posX > gp.screenWidth - width) {
            posX = gp.screenWidth - width;
        }
    }

    public void render(Graphics2D g2) {

        g2.drawImage(image, (int) posX, (int) posY, width, height, null);
    }

}
