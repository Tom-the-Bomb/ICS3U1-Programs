import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ParabolicBounceLoss extends JPanel implements ActionListener {
    static int diam = 50; // diameter of ball
    static int width = diam * 2; // width of box
    static int height = diam * 3; // height of box
    static double acceleration = 9.81; // gravity m/s^2
    static int offset = 50; // vertical offset

    double k = Math.sqrt((height - diam) / (acceleration / 2));
    double i = 0;
    int y = 0;

    double overallLoss = 0;
    double loss = height / 15;

    int delay = 10;
    boolean isIncreasing = true;
    Timer timer = new Timer(delay, this);

    public static void main(String[] args) {
        ParabolicBounceLoss comp = new ParabolicBounceLoss();
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
        double a = ((height - diam - overallLoss) / (k*k));
        if (a <= 0) {
            return;
        }
        y = (int) Math.round(a * i*i + overallLoss) + offset;

        i += isIncreasing ? 0.08 : -0.08;
        repaint();

        if (i >= k) {
            i = -k;
            isIncreasing = false;
        } else if (i <= -k) {
            i = -k;
            isIncreasing = true;

            overallLoss += loss;
            loss *= 0.9;

            delay *= 0.8;
            timer.setDelay(delay);
        }
    }
}