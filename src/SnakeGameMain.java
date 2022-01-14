import Objects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnakeGameMain extends JPanel  implements ActionListener {


    public static JFrame jFrame;
    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static int speed = 10;

    Snake s = new Snake(5, 6, 5, 5);
    Timer timer = new Timer(1000/speed,this);


    public  SnakeGameMain() {  // конструктор
        timer.start();
    }

    public void paint(Graphics g) { // рисовальщик
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
        for (int x = 0; x < WIDTH * SCALE + 6; x += SCALE + 28) {
            g.setColor(Color.white);
            g.drawLine(x, 0, x, HEIGHT * SCALE);

        }
        for (int y = 0; y < HEIGHT * SCALE; y += SCALE) {
            g.setColor(Color.white);
            g.drawLine(0, y, WIDTH * SCALE, y);

        }

        // рисуем змейку
        for (int l = 0; l < s.lenght; l++) {
            g.setColor(Color.GREEN);
            g.fillRect(s.sX[1] * SCALE + 1, s.sY[1] * SCALE + 1, SCALE - 1, SCALE - 1);
        }
    }

    public static void main(String[] args) {
        jFrame = new JFrame("Змейка");
        jFrame.setSize(WIDTH * SCALE, HEIGHT * SCALE); // размер

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // закрытие на крестик
        jFrame.setResizable(false); // растягиваемость
        jFrame.setLocationRelativeTo(null); // позиция по центру
        jFrame.setVisible(true); // делаем видимым
        jFrame.add(new SnakeGameMain());
    }

    public void actionPerformed(ActionEvent e) {
        s.move();
        repaint();
    }
}
