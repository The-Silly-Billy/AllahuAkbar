package GameObject.Map;

import GameObject.Brick.*;
import Main.GamePanel;

import java.awt.*;
/*
-----------MAP DE TEST GACH-----------
--------------------------------------

   !! KHONG DUOC XOA MAP NAY DI !!

 -------------------------------------
 */
public class MapTest extends Map{
    public MapTest(GamePanel gp) {
        super(gp);
        buildMap();
    }

    @Override
    public void buildMap() {
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
}
