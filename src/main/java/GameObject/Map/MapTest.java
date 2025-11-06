package GameObject.Map;

import GameObject.Brick.*;
import Main.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/*
-----------MAP DE TEST GACH-----------
--------------------------------------

   !! KHONG DUOC XOA MAP NAY DI !!

 -------------------------------------
 */
public class MapTest {

    GamePanel gp;

    public List<Brick> list = new ArrayList<>();

    public MapTest(GamePanel gp) {
        this.gp = gp;

        list.add(new BrBlue(gp, 48, 300));
        list.add(new BrGreen(gp, 96, 300));
        list.add(new BrLightBlue(gp, 144, 300));
        list.add(new BrPink(gp, 192, 300));
        list.add(new BrRed(gp, 240, 300));
        list.add(new BrWhite(gp, 288, 300));
        list.add(new BrWall(gp, 336, 300));
        list.add(new BrBrown(gp, 384, 300));
        list.add(new BrGray(gp, 432, 300));


    }

    public void render(Graphics2D g2) {
        for (Brick brick : list) {
            g2.drawImage(brick.image, (int) brick.posX, (int) brick.posY, brick.width, brick.height, null);
        }
    }
}
