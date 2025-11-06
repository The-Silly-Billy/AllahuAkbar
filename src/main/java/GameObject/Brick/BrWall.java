package GameObject.Brick;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class BrWall extends Brick {

    public BrWall(GamePanel gp, double posX, double posY) {
        super(gp);

        hitPoints = 0;
        isWall = true;

        this.posX = posX;
        this.posY = posY;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Brick/Wall.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
