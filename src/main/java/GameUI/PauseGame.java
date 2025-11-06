package GameUI;

import Main.GamePanel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import static GameUI.GameState.*;

public class PauseGame {
    private Button[] buttons = new Button[5];
    private BufferedImage backgroundImg;
    private GamePanel gp;
    public GameState state = PAUSED;
    private int buttonNumber = 0;
    private int pauseMenuX, pauseMenuY;
    private boolean musicButton0Muted = false;  // State for buttons[0]
    private boolean musicButton1Muted = false;  // State for buttons[1]

    private static final int PAUSE_MENU_WIDTH = 360;
    private static final int PAUSE_MENU_HEIGHT = 524;
    private static final int xCenterOffset = PAUSE_MENU_WIDTH / 2;
    private static final int yCenterOffset = PAUSE_MENU_HEIGHT / 2;

    public PauseGame( GamePanel gamePanel) {
        this.gp = gamePanel;
        this.pauseMenuX = (int) (gamePanel.screenWidth / 2 - xCenterOffset);
        this.pauseMenuY = (int) (gamePanel.screenHeight / 2 - yCenterOffset);
        loadButtons();
        loadBackground();
    }

    private void loadButtons() {
        buttons[0] = new Button(pauseMenuX + 236, pauseMenuY + 219,0, LoadMat.MUSIC_ON, MUTED, gp);
        buttons[1] = new Button(pauseMenuX + 236, pauseMenuY + 161,0, LoadMat.MUSIC_ON, MUTED, gp);
        buttons[2] = new Button(pauseMenuX + 47, pauseMenuY + 414,0, LoadMat.HOME_BUTTON, MENU,gp);
        buttons[3] = new Button(pauseMenuX + 148, pauseMenuY + 414,0, LoadMat.PLAY, PLAYING, gp);
        buttons[4] = new Button(pauseMenuX + 249, pauseMenuY + 414,0, LoadMat.RESTART,MENU, gp);
        buttons[0].setKeyOn(true);
        for(Button b : buttons) {
            b.setScale(2);
        }
    }

    private void loadBackground() {
        backgroundImg = LoadMat.GetSpriteAtlas(LoadMat.PAUSE_BACKGROUND);
    }

    public void update() {
        for(Button pause : buttons) {
            pause.update();
        }
    }

    public void resetButtons() {
        for( Button b : buttons) {
            b.reset();
        }
    }


    public void draw (Graphics g) {
        g.drawImage(backgroundImg,pauseMenuX,pauseMenuY, PAUSE_MENU_WIDTH, PAUSE_MENU_HEIGHT, null);

        for(Button pause : buttons) {
            pause.draw(g);
        }
    }

    public void setState( GameState state) {
        this.state = state;
    }

    private void handleButtonAction(int buttonIndex, GameState buttonState) {
        switch (buttonState) {
            case MUTED:
                toggleMusic(buttonIndex);
                break;
            case MENU:
                if (buttonIndex == 2) {
                    gp.setState(MENU);
                } else if (buttonIndex == 4) {
                    gp.resetGame();
                    gp.setState(PLAYING);
                }
                break;
            case PLAYING:
                gp.setState(PLAYING);
                break;
            default:
                break;
        }
    }

    private void toggleMusic(int buttonIndex) {
        if (buttonIndex == 0) {
            musicButton0Muted = !musicButton0Muted;
            String newImageSource = musicButton0Muted ? LoadMat.MUSIC_OFF : LoadMat.MUSIC_ON;
            buttons[0].setSource(newImageSource);
            System.out.println("Music Button 0 " + (musicButton0Muted ? "muted" : "unmuted"));
        } else if (buttonIndex == 1) {
            musicButton1Muted = !musicButton1Muted;
            String newImageSource = musicButton1Muted ? LoadMat.MUSIC_OFF : LoadMat.MUSIC_ON;
            buttons[1].setSource(newImageSource);
            System.out.println("Music Button 1 " + (musicButton1Muted ? "muted" : "unmuted"));
        }
    }

    public boolean isMusicMuted() {
        return musicButton0Muted || musicButton1Muted;
    }

    public boolean isMusicButton0Muted() {
        return musicButton0Muted;
    }

    public boolean isMusicButton1Muted() {
        return musicButton1Muted;
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            buttonNumber++;
            if (buttonNumber >= buttons.length)
                buttonNumber = 0; // wrap around to first
            resetButtons();
            buttons[buttonNumber].setKeyOn(true);
            gp.playSE(3);
        }

        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            buttonNumber--;
            if (buttonNumber < 0)
                buttonNumber = buttons.length - 1; // wrap around to last
            resetButtons();
            buttons[buttonNumber].setKeyOn(true);
            gp.playSE(3);
        }

        if (code == KeyEvent.VK_ENTER) {
            Button selectedButton = buttons[buttonNumber];
            GameState buttonState = selectedButton.getState();
            
            handleButtonAction(buttonNumber, buttonState);
        }
        if (code == KeyEvent.VK_ESCAPE) {
            gp.setState(PLAYING);
        }
    }


}
