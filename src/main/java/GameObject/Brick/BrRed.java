package GameObject.Brick;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class BrRed extends Brick {

    public BrRed(GamePanel gp, double posX, double posY) {
        super(gp);

        hitPoints = 5;

        this.posX = posX;
        this.posY = posY;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Brick/BrRed.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
