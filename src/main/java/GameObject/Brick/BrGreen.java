package GameObject.Brick;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class BrGreen extends Brick {

    public BrGreen(GamePanel gp, double posX, double posY) {
        super(gp);

        hitPoints = 3;

        this.posX = posX;
        this.posY = posY;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Brick/BrGreen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
