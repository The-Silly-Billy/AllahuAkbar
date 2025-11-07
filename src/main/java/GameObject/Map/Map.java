package GameObject.Map;

import GameObject.Brick.Brick;
import Main.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList; // ← THÊM import
public abstract class Map {
    GamePanel gp;
    public CopyOnWriteArrayList<Brick> list = new CopyOnWriteArrayList<>(); // ← SỬA: Dùng CopyOnWriteArrayList<Brick>
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
