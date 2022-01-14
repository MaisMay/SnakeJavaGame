package Objects;

import static java.awt.font.TextAttribute.WIDTH;

public class Snake {

    public int lenght = 2;
    public int direction = 0;

    public int sX[] = new int[300];
    public int sY[] = new int[300];

    public Snake(int x1, int y1, int x2, int y2) {
        sX[0] = x1;
        sX[1] = x2;
        sY[0] = y1;
        sY[1] = y2;

    }

    public void move () {
        for (int l = lenght;l>0;l--) {
            sX[l] = sX[l-1];
            sY[l] = sY[l-1];
        }


            // вверх
        if (direction ==0) sY[0]--;
            //  вниз
        if (direction ==2) sY[0]++;
            // право
        if (direction ==1) sX[0]++;
        // лево
        if (direction ==3) sX[0]--;

        // переходы

        
    }
}
