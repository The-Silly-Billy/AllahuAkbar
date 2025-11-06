package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import GameUI.GameState;

public class KeyHandler implements KeyListener{
    private GamePanel gamePanel;
    public boolean leftPressed, rightPressed, spacePressed;

    public KeyHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {

        if(gamePanel.getGameState() == GameState.MENU) {
            gamePanel.getMenu().keyPressed(e);
        } else if (gamePanel.getGameState() == GameState.PAUSED) {
            gamePanel.getPauseGame().keyPressed(e);
        }
        else if (gamePanel.getGameState() == GameState.PLAYING) {
            int code = e.getKeyCode();

            if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
                rightPressed = true;
            }
            if (code == KeyEvent.VK_SPACE) {
                spacePressed = true;
            }
            if (code == KeyEvent.VK_ESCAPE) {
                gamePanel.setState(GameState.PAUSED);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
        if(code == KeyEvent.VK_SPACE) {
            spacePressed = false;
        }
    }
}
