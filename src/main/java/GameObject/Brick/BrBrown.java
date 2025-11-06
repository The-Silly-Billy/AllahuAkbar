package GameObject.Brick;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class BrBrown extends Brick {

    public BrBrown(GamePanel gp, double posX, double posY) {
        super(gp);

        hitPoints = 2;

        this.posX = posX;
        this.posY = posY;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Brick/BrBrown.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
