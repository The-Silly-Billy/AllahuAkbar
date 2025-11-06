package GameObject;

import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Ball extends GameObject {

    GamePanel gp;
    KeyHandler keyH;
    BufferedImage image;

    Random rand = new Random();

    public int radius;
    public boolean isPlay;
    public int speed;
    public Vector2D move;
    public int ballDamage;

    public Ball(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        width = gp.originalTileSize;
        height = gp.originalTileSize;

        radius = width / 2;

        ballDamage = 1;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Ball.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        initPos();
    }

    public void initPos() {
        posX = (double) (gp.screenWidth - width) / 2;
        posY = (double) (gp.screenHeight - 150 - height);

        speed = 5;

        move = new Vector2D();

        move.angle = 45;

        isPlay = false;
    }

    public void update() {
        if(!isPlay && keyH.spacePressed) {
            move.changeVal(speed);
            isPlay = true;
        }

        posX += move.x;
        posY += move.y;

        //neu bong bay ra khoi man hinh
        if(posY < 0) {
            posY = 0;
            move.changeY();
        }

        if(posX < 0) {
            posX = 0;
            move.changeX();
        }

        if((int) posX + width > gp.screenWidth) {
            posX = gp.screenWidth - width;
            move.changeX();
        }

        if(!isPlay) {
            if(keyH.rightPressed) {
                posX += 4;
            }
            if(keyH.leftPressed) {
                posX -= 4;
            }

            if(posX < (double) (gp.originalTileSize * 5 - 10 - width) / 2) {
                posX = (double) (gp.originalTileSize * 5 - 10 - width) / 2;
            }

            if(posX > gp.screenWidth - (double) (gp.originalTileSize * 5 - 10 - width) / 2) {
                posX = gp.screenWidth - (double) (gp.originalTileSize * 5 - 10 - width) / 2;
            }
        }
    }

    public void render(Graphics2D g2) {
        g2.drawImage(image, (int) posX, (int) posY, width, height, null);
    }
}
