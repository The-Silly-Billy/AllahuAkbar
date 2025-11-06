package GameObject.Brick;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class BrLightBlue extends Brick {

    public BrLightBlue(GamePanel gp, double posX, double posY) {
        super(gp);

        hitPoints = 2;

        this.posX = posX;
        this.posY = posY;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Brick/BrLightBlue.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
