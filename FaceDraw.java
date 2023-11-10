import java.awt.*;
import javax.swing.*;

public class FaceDraw extends Canvas {
    private static int width = 600;
    private static int height = 850;
    public static void main(String[] args) {
        FaceDraw comp = new FaceDraw();
        JFrame frame = new JFrame("House");

        frame.setSize(width, height);
        frame.getContentPane()
            .setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(comp);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        Font font = new Font("Arial", Font.BOLD, 40);
        g.setFont(font);

        // face + ears
        g.setColor(new Color(254, 254, 0));
        g.fillOval(20, 50, width - 40, height - 50);
        g.fillOval(0, width / 2 + 75, 20, 100);
        g.fillOval(width - 20, width / 2 + 75, 20, 100);
        // mouth
        g.setColor(new Color(160, 160, 0));
        g.fillOval(width / 2 - 75, height - 200, 150, 40);
        // nose
        g.setColor(new Color(0, 176, 240));
        g.fillRect(width / 2 - 15, height - 440, 30, 180);
        // eyes
        g.setColor(Color.white);
        g.fillOval(width / 2 - 140, height - 540, 100, 80);
        g.fillOval(width / 2 + 60, height - 540, 100, 80);

        g.setColor(Color.black);
        g.drawString("FaceDraw", width / 2 - 20, 40);
        // face
        g.drawOval(20, 50, width - 40, height - 50);
        // ears
        g.drawOval(0, width / 2 + 75, 20, 100);
        g.drawOval(width - 20, width / 2 + 75, 20, 100);
        // mouth
        g.drawOval(width / 2 - 75, height - 200, 150, 40);
        // nose
        g.drawRect(width / 2 - 15, height - 440, 30, 180);
        // eyes
        g.drawOval(width / 2 - 140, height - 540, 100, 80);
        g.drawOval(width / 2 + 60, height - 540, 100, 80);
        // pupils
        g.fillOval(width / 2 - 110, height - 525, 40, 50);
        g.fillOval(width / 2 + 90, height - 525, 40, 50);
        // eyebrows
        g.fillRect(width / 2 - 140, height - 590, 110, 20);
        g.fillRect(width / 2 + 60, height - 590, 110, 20);
    }
}