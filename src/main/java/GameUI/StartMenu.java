package GameUI;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import Main.GamePanel;

import static GameUI.GameState.MENU;

public class StartMenu {
    private Button[] buttons = new Button[3];
    private BufferedImage backgroundImg;
    private int menuX, menuY, menuWidth, menuHeight;
    private GamePanel gp;
    public GameState state = MENU;
    private int buttonNumber = 0;

    public StartMenu( GamePanel gamePanel) {
        this.gp = gamePanel;
        loadButtons();
    }

    private void loadButtons() {
        buttons[0] = new Button(gp.screenWidth / 2 - Button.xCenterPoint , gp.screenHeight  / 2 - 2 * Button.MENU_B_HEIGHT,0,LoadMat.MENU_BUTTONS, GameState.PLAYING,gp);
        buttons[0].setKeyOn(true);
        buttons[1] = new Button(gp.screenWidth / 2 - Button.xCenterPoint , gp.screenHeight / 2 - Button.yCenterPoint,1, LoadMat.MENU_BUTTONS,GameState.OPTION,gp);
        buttons[2] = new Button(gp.screenWidth / 2 - Button.xCenterPoint , gp.screenHeight / 2 + Button.MENU_B_HEIGHT,2, LoadMat.MENU_BUTTONS, GameState.QUIT,gp);
    }

    public GameState getState() {
        return this.state;
    }

    public void setState( GameState state) {
        this.state = state;
    }

    public void update() {
        for(Button b : buttons) {
            b.update();
        }
    }

    public void resetButtons() {
        for( Button b : buttons) {
            b.reset();
        }
    }

    public void draw (Graphics g) {
        for(Button b : buttons) {
            b.draw(g);
        }
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
            state = buttons[buttonNumber].getState();
//            this.setState(state);

            gp.setState(state);
        }
    }
}
