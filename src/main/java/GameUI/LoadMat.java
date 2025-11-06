package GameUI;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadMat {
    public static final String MENU_BUTTONS = "Button/button_atlas.png";
    public static final String PAUSE_BACKGROUND = "menu_background.png";
    public static final String HOME_BUTTON = "Button/home.png";
    public static final String MUSIC_ON = "Button/music_on.png";
    public static final String MUSIC_OFF = "Button/music_off.png";
    public static final String RESTART = "Button/restart.png";
    public static final String PLAY = "Button/play.png";

    public static BufferedImage GetSpriteAtlas(String fileName) {
        BufferedImage img = null;
        InputStream is = LoadMat.class.getResourceAsStream("/" + fileName);
        try {
            img = ImageIO.read(is);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;
    }
}
