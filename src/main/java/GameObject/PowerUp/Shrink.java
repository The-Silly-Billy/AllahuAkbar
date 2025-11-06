package GameObject.PowerUp;

import GameObject.Paddle;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Shrink extends PowerUp {

    private Paddle paddle;
    private int originalWidth;

    public Shrink(GamePanel gp, double posX, double posY, Paddle paddle) {
        super(gp, posX, posY, 10); // 10 giây
        this.paddle = paddle;
        this.originalWidth = paddle.width;
        this.type = PowerUpType.SHRINK_PAD;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/heart.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void applyEffect() {
        paddle.width = originalWidth / 2; // Giảm một nửa chiều rộng
    }

    @Override
    public void removeEffect() {
        paddle.width = originalWidth; // Trả về kích thước ban đầu
    }
}