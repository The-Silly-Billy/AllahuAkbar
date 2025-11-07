package GameObject.Map;

import GameObject.Brick.*;
import Main.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Map1 extends Map {
    public Map1(GamePanel gp) {
        super(gp);
        buildMap();
    }

    @Override
    public void buildMap() {
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
}
