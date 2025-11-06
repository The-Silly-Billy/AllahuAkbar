package GameObject.Brick;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class BrBlue extends Brick {

    public BrBlue(GamePanel gp, double posX, double posY) {
        super(gp);

        hitPoints = 1;

        this.posX = posX;
        this.posY = posY;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Brick/BrBlue.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
