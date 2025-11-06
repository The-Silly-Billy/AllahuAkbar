package GameObject.PowerUp;

import GameObject.Heart;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Pluslife extends PowerUp {

    public Pluslife(GamePanel gp, double posX, double posY) {
        super(gp, posX, posY, 0); // Không có duration, hiệu ứng tức thì
        this.type = PowerUpType.PLUS_HEART;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/heart.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void applyEffect() {
        // Thêm 1 mạng nếu chưa đầy
        if(gp.heartList.size() < 5) { // Giới hạn tối đa 5 mạng
            int newHeartX = 10 + 50 * gp.heartList.size();
            gp.heartList.add(new Heart(gp, newHeartX, gp.screenHeight - 50));
        }
    }

    @Override
    public void removeEffect() {
        // Không cần remove vì là hiệu ứng vĩnh viễn
    }
}