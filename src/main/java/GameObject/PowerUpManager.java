package GameObject;

import GameObject.PowerUp.*;
import Main.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class PowerUpManager {
    GamePanel gp;
    Random rand = new Random();

    public List<PowerUp> activePowerUps = new ArrayList<>();

    // Xác suất rơi PowerUp khi phá gạch (20%)
    private static final double DROP_CHANCE = 0.2;

    public PowerUpManager(GamePanel gp) {
        this.gp = gp;
    }

    // Tạo PowerUp ngẫu nhiên tại vị trí gạch bị phá
    public void trySpawnPowerUp(double brickX, double brickY, Paddle paddle, Ball ball) {
        if(rand.nextDouble() < DROP_CHANCE) {
            // Tạo PowerUp ở giữa gạch
            double centerX = brickX + (gp.originalTileSize * 3 - gp.originalTileSize * 2) / 2.0;
            double centerY = brickY;

            // Random loại PowerUp
            int type = rand.nextInt(4);
            PowerUp powerUp = null;

            switch(type) {
                case 0:
                    powerUp = new FireBall(gp, centerX, centerY, ball);
                    break;
                case 1:
                    powerUp = new Pluslife(gp, centerX, centerY);
                    break;
                case 2:
                    powerUp = new Expandpad(gp, centerX, centerY, paddle);
                    break;
                case 3:
                    powerUp = new Shrink(gp, centerX, centerY, paddle);
                    break;
            }

            if(powerUp != null) {
                activePowerUps.add(powerUp);
            }
        }
    }

    public void update(Paddle paddle) {
        Iterator<PowerUp> iterator = activePowerUps.iterator();

        while(iterator.hasNext()) {
            PowerUp pu = iterator.next();
            pu.update();

            // Kiểm tra va chạm với paddle (khi PowerUp đang rơi)
            if(GameObject.isCollide(pu, paddle) && pu.isAppear) {
                pu.activate();
                pu.isAppear = false; // Không hiển thị nữa
            }

            // Xóa nếu không còn active và không còn hiển thị
            if(!pu.isAppear && !pu.isActive) {
                iterator.remove();
            }
        }
    }

    public void render(Graphics2D g2) {
        // Render PowerUp đang rơi
        for(PowerUp pu : activePowerUps) {
            if(pu.isAppear) {
                pu.render(g2);
            }
        }

        // Hiển thị thông tin hiệu ứng đang active
        int yOffset = 10;
        g2.setFont(new Font("Arial", Font.PLAIN, 16));

        for(PowerUp pu : activePowerUps) {
            if(pu.isActive && pu.getRemainingTime() > 0) {
                String text = pu.getType().name() + ": " + pu.getRemainingTime() + "s";
                g2.setColor(Color.YELLOW);
                g2.drawString(text, 10, yOffset);
                yOffset += 20;
            }
        }
    }

    public void reset() {
        // Remove effect của tất cả PowerUp đang active
        for(PowerUp pu : activePowerUps) {
            if(pu.isActive) {
                pu.removeEffect();
            }
        }
        activePowerUps.clear();
    }
}