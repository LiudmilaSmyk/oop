import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RotatingLine extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int LINE_LENGTH = 100;
    private static final int CENTER_X = WIDTH / 2;
    private static final int CENTER_Y = HEIGHT / 2;

    private int angle = 0;
    private Timer timer;

    public RotatingLine() {
        setTitle("Rotating Line");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += 5;
                if (angle >= 360) {
                    angle = 0;
                }
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // Очистка фона
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);

        // Вычисление координат конца отрезка
        int endX = CENTER_X + (int) (LINE_LENGTH * Math.cos(Math.toRadians(angle)));
        int endY = CENTER_Y + (int) (LINE_LENGTH * Math.sin(Math.toRadians(angle)));

        // Изменение цвета отрезка
        g2d.setColor(new Color((angle * 255 / 360) % 256, (angle * 255 / 180) % 256, (angle * 255 / 90) % 256));

        // Рисование отрезка
        g2d.setStroke(new BasicStroke(3));
        g2d.drawLine(CENTER_X, CENTER_Y, endX, endY);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RotatingLine().setVisible(true);
            }
        });
    }
}
