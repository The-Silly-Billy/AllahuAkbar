package Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Background {
    GamePanel gp;
    BufferedImage image;

    public Background(GamePanel gp) {
        this.gp = gp;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics2D g2) {
        g2.drawImage(image, 0, 0, gp.screenWidth, gp.screenHeight, null);
    }
}
