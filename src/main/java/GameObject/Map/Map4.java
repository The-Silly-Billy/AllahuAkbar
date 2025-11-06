package GameObject.Map;

import GameObject.Brick.*;
import Main.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Map4 {

    GamePanel gp;

    public List<Brick> list = new ArrayList<>();

    public Map4(GamePanel gp) {
        this.gp = gp;

        for (int i = 0; i < 4; i++) {
            if (i == 3) {
                list.add(new BrGray(gp, 48, 150 + 25 * i));
            } else {
                list.add(new BrBlue(gp,48 ,150 + 25 * i));
            }
        }

        for (int i = 0; i < 4; i++) {
            list.add(new BrBlue(gp, 96, 125 + 25 * i));
        }

        for (int i = 0; i < 6; i++) {
            if (i == 5) {
                list.add(new BrGray(gp, 144, 100 + 25 * i));
            } else if (i < 2) {
                list.add(new BrBlue(gp, 144, 100 + 25 * i));
            } else {
                list.add(new BrWhite(gp, 144, 100 + 25 * i));
            }
        }

        list.add(new BrWall(gp, 144, 300));
        list.add(new BrWall(gp, 144, 325));

        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                list.add(new BrBlue(gp, 192, 100));
            } else {
                list.add(new BrWhite(gp, 192, 100 + 25 * i));
            }
        }

        list.add(new BrWall(gp, 192, 325));
        list.add(new BrWall(gp, 192, 350));

        for (int i = 0; i < 11; i++) {
            if (i < 2) {
                list.add(new BrGray(gp, 240, 75 + 25 * i));
            } else if (i < 6) {
                list.add(new BrWhite(gp, 240, 75 + 25 * i));
            } else if ( i < 9) {
                list.add(new BrGray(gp, 240, 75 + 25 * i));
            } else {
                list.add(new BrWall(gp, 240, 75 + 25 * i));
            }
        }

        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                list.add(new BrGreen(gp, 288, 100));
            } else {
                list.add(new BrWhite(gp, 288, 100 + 25 * i));
            }
        }

        for (int i = 0; i < 6; i++) {
            if (i == 5) {
                list.add(new BrGray(gp, 336, 100 + 25 * i));
            } else if (i < 2) {
                list.add(new BrGreen(gp, 336, 100 + 25 * i));
            } else {
                list.add(new BrWhite(gp, 336, 100 + 25 * i));
            }
        }

        for (int i = 0; i < 4; i++) {
            list.add(new BrGreen(gp, 384, 125 + 25 * i));
        }

        for (int i = 0; i < 4; i++) {
            if (i == 3) {
                list.add(new BrGray(gp, 432, 150 + 25 * i));
            } else {
                list.add(new BrGreen(gp,432 ,150 + 25 * i));
            }
        }

    }

    public void render(Graphics2D g2) {
        for (Brick brick : list) {
            g2.drawImage(brick.image, (int) brick.posX, (int) brick.posY, brick.width, brick.height, null);
        }
    }
}
