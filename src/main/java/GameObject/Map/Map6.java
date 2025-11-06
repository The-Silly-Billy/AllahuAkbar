package GameObject.Map;

import GameObject.Brick.*;
import Main.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Map6 {

    GamePanel gp;

    public List<Brick> list = new ArrayList<>();

    public Map6(GamePanel gp) {
        this.gp = gp;

        list.add(new BrWhite(gp, 0, 175));
        list.add(new BrGreen(gp, 0, 275));

        for (int j = 0; j < 3; j++) {
            list.add(new BrWall(gp, 0, 300 + j * 25));
        }

        list.add(new BrWhite(gp, 48, 150));
        list.add(new BrRed(gp, 48, 175));
        list.add(new BrWhite(gp, 48, 200));
        list.add(new BrGreen(gp, 48, 300));
        list.add(new BrGreen(gp, 48, 325));
        list.add(new BrWall(gp, 48, 350));

        for (int i = 0; i < 10; i++) {
            if (i == 0 || i == 4) {
                list.add(new BrWhite(gp, 96, 125 + i * 25));
            }
            if (i == 1 || i == 3) {
                list.add(new BrRed(gp, 96, 125 + i * 25));
            }

            if (i == 2) {
                list.add(new BrWall(gp, 96, 125 + i * 25));
            }

            if (4 < i && i < 9) {
                list.add(new BrPink(gp, 96, 125 + i * 25));
            }

            if (i == 9) {
                list.add(new BrGreen(gp, 96, 125 + i * 25));
            }
        }

        list.add(new BrWhite(gp, 144, 50));
        list.add(new BrWhite(gp, 144, 150));
        list.add(new BrRed(gp, 144, 175));
        list.add(new BrWhite(gp, 144, 200));
        list.add(new BrGreen(gp, 144, 300));
        list.add(new BrGreen(gp, 144, 325));
        list.add(new BrWall(gp, 144, 350));

        list.add(new BrWhite(gp, 192, 175));
        list.add(new BrGreen(gp, 192, 275));
        list.add(new BrGreen(gp, 192, 350));

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                list.add(new BrWhite(gp, 192 + j * 48, 50 + i * 25));
            }
        }

        list.add(new BrWhite(gp, 336, 75));

        for (int i = 0; i < 3; i++) {
            list.add(new BrWall(gp, 240 + i * 48, 100));
        }

        list.add(new BrWhite(gp, 432, 0));
        list.add(new BrWhite(gp, 432, 25));
        list.add(new BrWhite(gp, 480, 25));

        list.add(new BrWall(gp, 240, 250));
        list.add(new BrPink(gp, 240, 300));
        list.add(new BrGreen(gp, 240, 325));

        list.add(new BrGreen(gp, 288, 275));
        list.add(new BrGreen(gp, 288, 300));

        list.add(new BrGreen(gp, 336, 250));
        list.add(new BrWall(gp, 336, 300));
        list.add(new BrPink(gp, 336, 325));
        list.add(new BrGreen(gp, 336, 350));

        for (int i = 0; i < 5; i++) {
            list.add(new BrGreen(gp, 384, 250 + i * 25));
        }

        list.add(new BrGreen(gp, 432, 250));
        list.add(new BrPink(gp, 432, 275));
        list.add(new BrGreen(gp, 432, 325));

        list.add(new BrPink(gp, 480, 225));
        list.add(new BrGreen(gp, 480, 275));
    }

    public void render(Graphics2D g2) {
        for (Brick brick : list) {
            g2.drawImage(brick.image, (int) brick.posX, (int) brick.posY, brick.width, brick.height, null);
        }
    }
}
