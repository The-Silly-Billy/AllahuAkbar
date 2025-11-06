package GameObject.Brick;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class BrGray extends Brick {

    public BrGray(GamePanel gp, double posX, double posY) {
        super(gp);

        hitPoints = 4;

        this.posX = posX;
        this.posY = posY;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Brick/BrGray.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
