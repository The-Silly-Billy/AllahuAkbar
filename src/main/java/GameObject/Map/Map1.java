package GameObject.Map;

import GameObject.Brick.*;
import Main.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Map1 {

    GamePanel gp;

    public List<Brick> list = new ArrayList<>();

    public Map1(GamePanel gp) {
        this.gp = gp;

        for (int i = 0; i <= 720; i += 48) {
            list.add(new BrBrown(gp, i, 100));
        }
        for (int i = 0; i <= 720; i += 48) {
            list.add(new BrRed(gp, i, 125));
        }
        for (int i = 0; i <= 720; i += 48) {
            list.add(new BrBlue(gp, i, 150));
        }
        for (int i = 0; i <= 720; i += 48) {
            list.add(new BrGray(gp, i, 175));
        }
        for (int i = 0; i <= 720; i += 48) {
            list.add(new BrPink(gp, i, 200));
        }
        for (int i = 0; i <= 720; i += 48) {
            list.add(new BrGreen(gp, i, 225));
        }

    }

    public void render(Graphics2D g2) {
        for (Brick brick : list) {
            g2.drawImage(brick.image, (int) brick.posX, (int) brick.posY, brick.width, brick.height, null);
        }
    }
}
