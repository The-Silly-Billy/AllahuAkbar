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

    public static void interact(Ball ball, Brick brick) {
        switch(typeCollideBnR(ball, brick)) {
            case 1:
                if(ball.move.x > 0) {
                    ball.move.changeX();
                    System.out.println(1);
                }
                break;

            case 2:
                if(ball.move.y > 0) {
                    ball.move.changeY();
                    System.out.println(2);
                }
                break;

            case 3:
                if(ball.move.x < 0) {
                    ball.move.changeX();
                    System.out.println(3);
                }
                break;

            case 4:
                if(ball.move.y < 0) {
                    ball.move.changeY();
                    System.out.println(4);
                }
                break;

            case 5:
                //sai so va cham goc la 5.0 pixels
                boolean left = Math.abs((ball.posX + ball.width) - brick.posX) < 5.0;
                boolean right = Math.abs(ball.posX - (brick.posX + brick.width)) < 5.0;
                boolean top = Math.abs((ball.posY + ball.height) - brick.posY) < 5.0;
                boolean bottom = Math.abs(ball.posY - (brick.posY + brick.height)) < 5.0;

                if(top && left) {
                    if(ball.move.x < 0 && ball.move.y > 0) {
                        ball.move.changeY();
                    } else if(ball.move.x > 0 && ball.move.y < 0) {
                        ball.move.changeX();
                    } else {
                        ball.move.changeX();
                        ball.move.changeY();
                    }
                    System.out.println("top-left");
                } else if(top && right) {
                    if(ball.move.x < 0 && ball.move.y < 0) {
                        ball.move.changeX();
                    } else if(ball.move.x > 0 && ball.move.y > 0) {
                        ball.move.changeY();
                    } else {
                        ball.move.changeX();
                        ball.move.changeY();
                    }
                    System.out.println("top-right");
                } else if(bottom && left) {
                    if(ball.move.x < 0 && ball.move.y < 0) {
                        ball.move.changeY();
                    } else if(ball.move.x > 0 && ball.move.y > 0) {
                        ball.move.changeX();
                    } else {
                        ball.move.changeX();
                        ball.move.changeY();
                    }
                    System.out.println("bottom-left");
                } else if(bottom && right) {
                    if(ball.move.x > 0 && ball.move.y < 0) {
                        ball.move.changeY();
                    } else if(ball.move.x < 0 && ball.move.y > 0) {
                        ball.move.changeX();
                    } else {
                        ball.move.changeX();
                        ball.move.changeY();
                    }
                    System.out.println("bottom-right");
                } else {
                    ball.move.changeX();
                    ball.move.changeY();
                    System.out.println("magic");
                }
                break;

            default:
                break;
        }
    }
}
