package GameObject;

import GameObject.Brick.Brick;

public class GameObject {
    public double posX,posY;
    public int width, height;
    public int speed;

    public static boolean isCollide(GameObject obj1, GameObject obj2) {
        return  obj1.posX + obj1.width >= obj2.posX &&
                obj2.posX + obj2.width >= obj1.posX &&
                obj1.posY + obj1.height >= obj2.posY &&
                obj2.posY + obj2.height >= obj1.posY;
    }

    public static int typeCollideBnR(Ball ball, GameObject rect) {
        double ballCenterX = ball.posX + ball.width / 2.0;
        double ballCenterY = ball.posY + ball.height / 2.0;

        double closeX = ballCenterX;
        double closeY = ballCenterY;

        if(ballCenterX > rect.posX + rect.width) {
            closeX = rect.posX + rect.width;                    //phai (3)
        } else if(ballCenterX < rect.posX) {
            closeX = rect.posX;                                 //trai (1)
        }

        if(ballCenterY < rect.posY) {
            closeY = rect.posY;                                 //tren (2)
        } else if(ballCenterY > rect.posY + rect.height) {
            closeY = rect.posY + rect.height;                   //duoi (4)
        }

        double distX = closeX - ballCenterX;
        double distY = closeY - ballCenterY;

        if(isCollide(ball, rect)) {
            if(Math.abs(distX) > 0 && Math.abs(distY) > 0) {
                return 5;
            }

            if(Math.abs(distX) > Math.abs(distY)) {
                if(closeX == rect.posX) {
                    return 1;
                } else {
                    return 3;
                }
            } else {
                if(closeY == rect.posY) {
                    return 2;
                } else {
                    return 4;
                }
            }
        }

        return 0;
    }
}
