package GameObject.Brick;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class BrPink extends Brick {

    public BrPink(GamePanel gp, double posX, double posY) {
        super(gp);

        hitPoints = 3;

        this.posX = posX;
        this.posY = posY;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Brick/BrPink.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
