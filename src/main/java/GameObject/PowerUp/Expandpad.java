package GameObject.PowerUp;

import GameObject.Paddle;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Expandpad extends PowerUp {

    private Paddle paddle;


    public Expandpad(GamePanel gp, double posX, double posY, Paddle paddle) {
        super(gp, posX, posY, 15); // 15 giây
        this.paddle = paddle;

        this.type = PowerUpType.EXPAND_PAD;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/expandpad.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void applyEffect() {
        paddle.width = paddle.width * 2;
    }
        @Override
    public void removeEffect() {
            paddle.width = paddle.ORIGINAL_WIDTH;
    }
}