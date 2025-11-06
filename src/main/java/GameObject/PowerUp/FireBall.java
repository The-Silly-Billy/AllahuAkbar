package GameObject.PowerUp;

import GameObject.Ball;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class FireBall extends PowerUp {

    private Ball ball;
    private int originalDamage;

    public FireBall(GamePanel gp, double posX, double posY, Ball ball) {
        super(gp, posX, posY, 10); // 10 giây
        this.ball = ball;
        this.originalDamage = ball.ballDamage;
        this.type = PowerUpType.FIREBALL;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/heart.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void applyEffect() {
        ball.ballDamage = 100; // Sát thương cao, phá mọi gạch
    }

    @Override
    public void removeEffect() {
        ball.ballDamage = originalDamage; // Trả về sát thương ban đầu
    }
}