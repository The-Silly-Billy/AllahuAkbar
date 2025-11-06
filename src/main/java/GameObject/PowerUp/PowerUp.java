package GameObject.PowerUp;

import GameObject.GameObject;
import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class PowerUp extends GameObject {

    protected GamePanel gp;
    public BufferedImage image;
    protected int duration;   // thời gian hiệu lực (frames)
    public boolean isAppear;
    public boolean isActive;
    protected PowerUpType type;

    public enum PowerUpType {
        FIREBALL,
        PLUS_HEART,
        EXPAND_PAD,
        SHRINK_PAD
    }

    public PowerUp(GamePanel gp, double posX, double posY, int durationInSeconds) {
        this.gp = gp;
        this.posX = posX;
        this.posY = posY;
        this.duration = durationInSeconds * 60; // convert to frames
        this.speed = 2;
        this.isAppear = true;
        this.isActive = false;

        width = gp.originalTileSize * 2;
        height = gp.originalTileSize * 2;
    }

    public void update() {
        if(isAppear) {
            posY += speed;
            if(posY >= gp.screenHeight) {
                isAppear = false;
            }
        }

        if(isActive) {
            duration--;
            if(duration <= 0) {
                removeEffect();
                isActive = false;
            }
        }
    }

    public void activate() {
        if(!isActive) {
            applyEffect();
            isActive = true;
        }
    }

    // Abstract methods - các class con phải implement
    protected abstract void applyEffect();
    public abstract void removeEffect();

    public void render(Graphics2D g2) {
        if(isAppear && image != null) {
            g2.drawImage(image, (int) posX, (int) posY, width, height, null);
        }
    }

    public PowerUpType getType() {
        return type;
    }

    public int getRemainingTime() {
        return duration / 60; // convert frames to seconds
    }
}