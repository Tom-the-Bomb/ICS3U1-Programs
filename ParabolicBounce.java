import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ParabolicBounce extends JPanel implements ActionListener {
    static int diam = 50; // diameter of ball
    static int width = diam * 2; // width of box
    static int height = diam * 3; // height of box
    static double acceleration = 9.81; // gravity m/s^2
    static int offset = 50; // vertical offset

    double k = Math.sqrt((height - diam) / (acceleration / 2));
    double i = 0;
    int y = 0;
    boolean isIncreasing = true;
    Timer timer = new Timer(10, this);

    public static void main(String[] args) {
        ParabolicBounce comp = new ParabolicBounce();
        JFrame frame = new JFrame("Ball Bounce");
        frame.setSize(width, height + offset);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(comp);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.drawRect(0, 0, width, height + offset);

        g.setColor(Color.red);
        g.fillOval(width / 2 - diam / 2, y, diam, diam);
        timer.start();
    }

    public void actionPerformed(ActionEvent event) {
        y = (int) Math.round(acceleration / 2 * i*i + offset);

        i += isIncreasing ? 0.08 : -0.08;
        repaint();

        if (i >= k) {
            i = -k;
            isIncreasing = false;
        } else if (i <= -k) {
            i = -k;
            isIncreasing = true;
        }
    }
}