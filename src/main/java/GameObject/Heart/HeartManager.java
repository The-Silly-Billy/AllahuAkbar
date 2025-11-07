package GameObject.Heart;

import Main.GamePanel;

import java.awt.*;
import java.util.ArrayList;

public class HeartManager {
    GamePanel gp;
    ArrayList<Heart> heartList = new ArrayList<>();

    public HeartManager(GamePanel gp) {
        this.gp = gp;
        init();
    }

    public void init() {
        if(!heartList.isEmpty()) {
            heartList.clear();
        }

        for(int i = 0; i < 3; i++) {
            heartList.add(new Heart(gp, 10 + 30 * i));
        }
    }

    public void inc() {
        if(heartList.size() < 6) {
            double heartX = heartList.getLast().posX + 30;
            heartList.add(new Heart(gp, (int) heartX));
        }
    }

    public void dec() {
        heartList.removeLast();
    }

    public boolean isEmpty() {
        return heartList.isEmpty();
    }

    public void render(Graphics2D g2) {
        for(Heart heart : heartList) {
            g2.drawImage(heart.image, (int) heart.posX, (int) heart.posY, heart.width, heart.height, null);
        }
    }
}
