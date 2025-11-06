package GameObject.PowerUp;

import GameObject.Paddle;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Expandpad extends PowerUp {

    private Paddle paddle;
    private int originalWidth;

    public Expandpad(GamePanel gp, double posX, double posY, Paddle paddle) {
        super(gp, posX, posY, 15); // 15 giây
        this.paddle = paddle;
        this.originalWidth = paddle.width;
        this.type = PowerUpType.EXPAND_PAD;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/heart.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void applyEffect() {
        paddle.width = originalWidth * 2; // Tăng gấp đôi chiều rộng
    }

    @Override
    public void removeEffect() {
        paddle.width = originalWidth; // Trả về kích thước ban đầu
    }
}