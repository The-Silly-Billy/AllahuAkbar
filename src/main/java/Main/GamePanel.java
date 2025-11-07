package Main;

import GameObject.Brick.*;
import GameObject.Heart.HeartManager;
import GameObject.Map.*;
import GameObject.GameObject;
import GameObject.Ball;
import GameObject.Paddle;
import GameObject.PowerUpManager;
import GameObject.Heart.Heart;
import GameUI.PauseGame;
import GameUI.StartMenu;
import GameUI.GameState;

import javax.swing.JPanel;
import java.awt.*;
import java.io.InputStream;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable{

    //Cai dat pixel
    public final int originalTileSize = 16;                         // 1 khung pixel 16x16
    final int scale = 3;                                            // phong dai khung len 3 lan
    final int tileSize = originalTileSize * scale;                  // 48 pixel

    //Kich co man hinh
    final int maxScreenCol = 11;
    final int maxScreenRow = 15;

    public final int screenWidth = tileSize * maxScreenCol;        //576 pixels
    public final int screenHeight = tileSize * maxScreenRow;       //768 pixels

    StartMenu menu = new StartMenu(this);
    PauseGame pauseGame = new PauseGame(this);
    private GameState state = GameState.MENU;

    //FPS
    int FPS = 60;

    KeyHandler keyH = new KeyHandler(this);
    Sound sound = new Sound();
    Background background = new Background(this);

    Thread gameThread;

    Random rand = new Random();

    //Player
    Paddle paddle = new Paddle(this, keyH);
    //Ball
    Ball ball = new Ball(this, keyH);
    //Brick Map
    Map4 map = new Map4( this);
    //PowerUp
    PowerUpManager powerUp = new PowerUpManager(this);

    //Hearts
    public HeartManager heartList = new HeartManager(this);

    int scorePlayer = 0;
    Font customFont = null;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

        this.addKeyListener(keyH);
        this.setFocusable(true);

        playMusic(0);

        try {
            InputStream inputStream=getClass().getResourceAsStream("/Font/Jersey25-Regular.ttf");
            customFont = Font.createFont(Font.TRUETYPE_FONT,inputStream);
            GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("loi");
        }
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000.0 / FPS;      // tgian ve 1 khung hinh (0.0166s)
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {

            //Setup FPS dua tren "DELTA METHOD"
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1) {
                update();
                repaint();
                delta--;
            }

        }
    }

    public GameState getGameState() {
        return this.state;
    }

    public StartMenu getMenu() {
        return menu;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public PauseGame getPauseGame() {
        return this.pauseGame;
    }

    public void update() {
        if(state == GameState.PLAYING && heartList.isEmpty()) {
            setState(GameState.MENU);
            resetGame();
            return;
        }
        switch (state) {
            case MENU:
                menu.update();
                break;
            case PLAYING:
                paddle.update();
                ball.update();
                powerUp.update(paddle);
                break;
            case GAME_OVER:
                break;
            case QUIT:
                System.exit(0);
                break;
            case PAUSED:
                pauseGame.update();
                break;
        }

        //Va cham voi pad
        if(GameObject.isCollide(ball, paddle)) {
            ball.reaction(paddle);
        }

        //Va cham vs gach
        for(int i = 0; i < map.list.size(); i++) {
            Brick brick = map.list.get(i);

            if(GameObject.isCollide(ball, brick)) {
                playSE(4);
                ball.reaction(brick);
                brick.takeHit(ball);
            }

            if (brick.isDestroy()) {
                scorePlayer++;
                powerUp.trySpawnPowerUp(brick.posX,brick.posY, paddle, ball);
                repaint();
                map.list.remove(i);
                i--;
            }
        }

        //Va cham voi PowerUp



        //Update tut mau
        //khi het ba mang out game
        if(ball.posY > screenHeight - ball.radius) {
            if (!heartList.isEmpty()) {
                heartList.dec();
                ball.initPos();
                paddle.initPos();
            }
            //Game Over
            ball.initPos();
            paddle.initPos();
        }

    }

    //method ve
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        background.render(g2);

        switch (state) {
            case MENU:
                menu.draw(g2);
                break;
            case PLAYING:
                paddle.render(g2);
                ball.render(g2);
                powerUp.render(g2);
                map.render(g2);

                heartList.render(g2);

                if (customFont != null) {

                    g2.setFont(customFont.deriveFont(Font.PLAIN, 20f));
                }
                g2.setColor(Color.white);

                g2.drawString("Score : " + scorePlayer,screenWidth - 100,screenHeight - 40);
                break;
            case GAME_OVER:
                //Game over
            case PAUSED:
                paddle.render(g2);
                ball.render(g2);

                map.render(g2);

                heartList.render(g2);

                if (customFont != null) {

                    g2.setFont(customFont.deriveFont(Font.PLAIN, 20f));
                }
                g2.setColor(Color.white);

                g2.drawString("Score : " + scorePlayer, screenWidth - 100,screenHeight - 40);
                pauseGame.draw(g2);
                break;

        }
        g2.dispose();
    }

    public void resetGame() {
        ball.initPos();
        paddle.initPos();
        heartList.init();
        map = new Map4(this);
        scorePlayer = 0;
    }

    public void playMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic() {
        sound.stop();
    }

    public void playSE(int i) {
        sound.setFile(i);
        sound.play();
    }
}
