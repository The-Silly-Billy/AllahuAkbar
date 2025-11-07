package GameObject.PowerUp;

import GameObject.Heart.Heart;
import GameObject.Heart.HeartManager;
import Main.GamePanel;

public class Pluslife extends PowerUp {

    public Pluslife(GamePanel gp, double posX, double posY) {
        super(gp, posX, posY, 0); // Không có duration, hiệu ứng tức thì
        this.type = PowerUpType.PLUS_HEART;
    }

    @Override
    protected void applyEffect() {
        // Thêm 1 mạng nếu chưa đầy 5 mang
        gp.heartList.inc();
    }

    @Override
    public void removeEffect() {
        // Không cần remove vì là hiệu ứng vĩnh viễn
    }
}