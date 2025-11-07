package GameObject.PowerUp;

import GameObject.Paddle;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Shrink extends PowerUp {

    private Paddle paddle;


    public Shrink(GamePanel gp, double posX, double posY, Paddle paddle) {
        super(gp, posX, posY, 10); // 10 giây
        this.paddle = paddle;

        this.type = PowerUpType.SHRINK_PAD;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/shrinkpad.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void applyEffect() {
        paddle.width /= 2; // Giảm một nửa chiều rộng
    }

    @Override
    public void removeEffect() {
        paddle.width =   paddle.ORIGINAL_WIDTH;; // Trả về kích thước ban đầu
    }
}