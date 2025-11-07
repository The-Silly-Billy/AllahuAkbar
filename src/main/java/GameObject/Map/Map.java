package GameObject.Map;

import GameObject.Brick.Brick;
import Main.GamePanel;

import java.awt.*;
import java.util.ArrayList;

public abstract class Map {
    GamePanel gp;
    public ArrayList<Brick> list = new ArrayList<>();

    public Map(GamePanel gp) {
        this.gp = gp;
        buildMap();
    }

    public abstract void buildMap();

    public void render(Graphics2D g2) {
        for (Brick brick : list) {
            g2.drawImage(brick.image, (int) brick.posX, (int) brick.posY, brick.width, brick.height, null);
        }
    }
}
