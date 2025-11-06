package GameUI;

import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Button {
    private int xPos, yPos, rowIndex;
    private BufferedImage[] imgs;
    private GameState state;
    private boolean keyOn, keyPressed;
    private int index;
    private String SOURCE;
    private int scale;

    protected static final int MENU_B_WIDTH = 140;
    protected static final int MENU_B_HEIGHT = 56;
    private static final int PAUSE_B_WIDTH = 28;
    private static final int PAUSE_B_HEIGHT = 28;
    protected static final int xCenterPoint = MENU_B_WIDTH / 2;
    protected  static final int yCenterPoint = MENU_B_HEIGHT / 2;
    private boolean isPauseButton;

    public Button(int xPos, int yPos, int rowIndex, String SOURCE,GameState state,GamePanel gamePanel) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.rowIndex = rowIndex;
        this.state = state;
        this.keyOn = false;
        this.keyPressed = false;
        this.SOURCE = SOURCE;
        this.scale = 1;
        this.isPauseButton = !SOURCE.equals(LoadMat.MENU_BUTTONS);
        loadImgs();
    }

    private void loadImgs() {
        imgs = new BufferedImage[3];
        BufferedImage temp = LoadMat.GetSpriteAtlas(SOURCE);
        if (temp == null) {
            System.err.println("Failed to load image: " + SOURCE);
            return;
        }
        
        int w, h;

        if (isPauseButton) {
            w = PAUSE_B_WIDTH;
            h = PAUSE_B_HEIGHT;
        } else {
            w = MENU_B_WIDTH;
            h = MENU_B_HEIGHT;
        }

        int imageWidth = temp.getWidth();
        int imageHeight = temp.getHeight();
        
        if (imageWidth < w * 3) {
            BufferedImage singleFrame = temp.getSubimage(0, rowIndex * h,
                    Math.min(w, imageWidth), Math.min(h, imageHeight - rowIndex * h));
            for (int i = 0; i < imgs.length; i++) {
                imgs[i] = singleFrame;
            }
        } else {
            for (int i = 0; i < imgs.length; i++) {
                imgs[i] = temp.getSubimage(
                        i * w,
                        rowIndex * h,
                        w,
                        h
                );
            }
        }
    }

    public void draw( Graphics g) {
        int w, h;

        if (isPauseButton) {
            w = PAUSE_B_WIDTH;
            h = PAUSE_B_HEIGHT;
        } else {
            w = MENU_B_WIDTH;
            h = MENU_B_HEIGHT;
        }

        g.drawImage(imgs[index], xPos, yPos, w *  this.scale, h * this.scale, null);
    }

    public void update() {
        index =0;
        if(keyOn) {
            index = 1;
        }
        if (keyPressed) {
            index = 2;
        }
    }

    public boolean isKeyOn() {
        return this.keyOn;
    }

    public void setKeyOn( boolean keyOn) {
        this.keyOn = keyOn;
    }

    public boolean isKeyPressed() {
        return this.keyPressed;
    }

    public void setKeyPressed( boolean keyPressed) {
        this.keyPressed = keyPressed;
    }

    public GameState getState() {
        return this.state;
    }
    public void reset() {
        keyOn = false;
        keyPressed = false;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public void setSource(String newSource) {
        this.SOURCE = newSource;
        loadImgs();
    }

    public String getSource() {
        return SOURCE;
    }


}
