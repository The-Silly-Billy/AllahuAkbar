package GameObject.Map;

import GameObject.Brick.*;
import Main.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Map2 extends Map {
    public Map2(GamePanel gp) {
        super(gp);
        buildMap();
    }

    @Override
    public void buildMap() {
        for (int i = 0; i < 10; i++) {
            list.add(new BrGray(gp, 0, 50 + 25 * i));
        }
        for (int i = 0; i < 9; i++) {
            list.add(new BrBlue(gp, 48, 75 + 25 * i));
        }
        for (int i = 0; i < 8; i++) {
            list.add(new BrGreen(gp, 96, 100 + 25 * i));
        }
        for (int i = 0; i < 7; i++) {
            list.add(new BrLightBlue(gp, 144, 125 + 25 * i));
        }
        for (int i = 0; i < 6; i++) {
            list.add(new BrRed(gp, 192, 150 + 25 * i));
        }
        for (int i = 0; i < 5; i++) {
            list.add(new BrGray(gp, 240, 175 + 25 * i));
        }
        for (int i = 0; i < 4; i++) {
            list.add(new BrBlue(gp, 288, 200 + 25 * i));
        }
        for (int i = 0; i < 3; i++) {
            list.add(new BrGreen(gp, 336, 225 + 25 * i));
        }
        for (int i = 0; i < 2; i++) {
            list.add(new BrLightBlue(gp, 384, 250 + 25 * i));
        }

        list.add(new BrRed(gp, 432, 275));

        for (int i = 0; i < 10; i++) {
            list.add(new BrBrown(gp, i * 48, 300));
        }

        list.add(new BrGray(gp, 480, 300));
    }
}
