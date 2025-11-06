package GameObject.Map;

import GameObject.Brick.*;
import Main.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Map3 {

    GamePanel gp;

    public List<Brick> list = new ArrayList<>();

    public Map3(GamePanel gp) {
        this.gp = gp;

        for (int i = 0; i < 11; i++) {
            list.add(new BrGreen(gp, i * 48, 75));
        }

        for (int i = 0; i < 11; i++) {
            if (i < 3) {
                list.add(new BrWhite(gp, i * 48, 125));
            } else {
                list.add(new BrWall(gp, i * 48, 125));
            }
        }

        for (int i = 0; i < 11; i++) {
            list.add(new BrRed(gp, i * 48, 175));
        }

        for (int i = 0; i < 11; i++) {
            if (i > 7) {
                list.add(new BrWhite(gp, i * 48, 225));
            } else {
                list.add(new BrWall(gp, i * 48, 225));
            }
        }

        for (int i = 0; i < 11; i++) {
            list.add(new BrPink(gp, i * 48, 275));
        }

        for (int i = 0; i < 11; i++) {
            if (i < 3) {
                list.add(new BrBlue(gp, i * 48, 325));
            } else {
                list.add(new BrWall(gp, i * 48, 325));
            }
        }

        for (int i = 0; i < 11; i++) {
            list.add(new BrBlue(gp, i * 48, 375));
        }

        for (int i = 0; i < 11; i++) {
            if (i > 7) {
                list.add(new BrBlue(gp, i * 48, 425));
            } else {
                list.add(new BrWall(gp, i * 48, 425));
            }
        }

    }

    public void render(Graphics2D g2) {
        for (Brick brick : list) {
            g2.drawImage(brick.image, (int) brick.posX, (int) brick.posY, brick.width, brick.height, null);
        }
    }
}
