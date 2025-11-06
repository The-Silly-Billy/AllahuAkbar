package GameObject.Map;

import GameObject.Brick.*;
import Main.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Map5 {

    GamePanel gp;

    public List<Brick> list = new ArrayList<>();

    public Map5(GamePanel gp) {
        this.gp = gp;

        for (int i = 0; i < 3; i++) {
            list.add(new BrLightBlue(gp, 288 + i * 48, 100));
            if (i == 2) {
                list.add(new BrPink(gp, 288 + i * 48, 125));
            } else {
                list.add(new BrLightBlue(gp, 288 + i * 48, 125));
            }
        }

        for (int i = 0; i < 5; i++) {
            if (i < 2) {
                list.add(new BrLightBlue(gp,240 + i * 48, 150));
            } else {
                list.add(new BrPink(gp,240 + i * 48, 150));
            }

            if (i == 3) {
                list.add(new BrPink(gp, 240 + i * 48, 175));
            } else if (i == 4) {
                list.add(new BrBlue(gp,240 + i * 48, 175));
            } else {
                list.add(new BrLightBlue(gp,240 + i * 48, 175));
            }

            if (i == 4) {
                list.add(new BrBlue(gp,240 + i * 48, 200));
            } else {
                list.add(new BrLightBlue(gp,240 + i * 48, 200));
            }
        }

        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                list.add(new BrWall(gp,192 + i * 48, 225));
                list.add(new BrBrown(gp,192 + i * 48, 250));
            } else if(i == 5) {
                list.add(new BrBlue(gp,192 + i * 48, 225));
                list.add(new BrBlue(gp,192 + i * 48, 250));
            } else {
                list.add(new BrLightBlue(gp,192 + i * 48, 225));
            }

            if (i == 1 || i == 4) {
                list.add(new BrBlue(gp,192 + i * 48, 250));
            }

            if (i == 2 || i == 3) {
                list.add(new BrLightBlue(gp,192 + i * 48, 250));
            }
        }

        for (int i = 0; i < 5; i++) {
            if (i < 2) {
                list.add(new BrBrown(gp, 192 + i * 48, 275));
            } else {
                list.add(new BrBlue(gp, 192 + i * 48, 275));
            }
        }

        for (int i = 0; i < 6; i++) {
            if (i == 0 || i == 2) {
                list.add(new BrWall(gp, 144 + i * 48, 300));
            } else if (i == 1) {
                list.add(new BrBrown(gp, 144 + i * 48, 300));
            } else {
                list.add(new BrBlue(gp, 144 + i * 48, 300));
            }
        }

        for (int i = 0; i < 4; i++) {
            list.add(new BrBrown(gp, 144 + i * 48, 325));

            if (i == 0 || i == 2) {
                list.add(new BrWall(gp, 96 + i * 48, 350));
            } else {
                list.add(new BrBrown(gp, 96 + i * 48, 350));
            }

            list.add(new BrBrown(gp, 96 + i * 48, 375));
        }

        for (int i = 0; i < 3; i++) {
            list.add(new BrBrown(gp, 96 + i * 48, 400));
            list.add(new BrBrown(gp, 48 + i * 48, 425));
        }

        for (int i = 0; i < 2; i++) {
            list.add(new BrBrown(gp, 48 + i * 48, 450));
        }

    }

    public void render(Graphics2D g2) {
        for (Brick brick : list) {
            g2.drawImage(brick.image, (int) brick.posX, (int) brick.posY, brick.width, brick.height, null);
        }
    }
}
