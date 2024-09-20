import java.awt.*;
import javax.swing.*;

public class HouseDraw extends Canvas {
    private static int width = 1518;
    private static int height = 850;

    public static void main(String[] args) {
        HouseDraw comp = new HouseDraw();
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
        g.setColor(Color.black);
        g.drawString("House", width / 2 - 20, 40);

        int bgHeight = height - 50;
        g.setColor(new Color(126, 95, 0));
        g.fillRect(0, 50, width, bgHeight);

        int triBase = 50 + bgHeight / 3;
        g.setColor(Color.black);
        int[] triX = {0, width / 2, width};
        int[] triY = {triBase, 50, triBase};
        g.drawPolygon(triX, triY, 3);

        int rectHeight = height - triBase;
        int doorX = 2 * (width / 5);
        int doorY = triBase + rectHeight / 3;
        int doorWidth = width / 5;
        int doorHeight = 2 * (rectHeight / 3);
        int doorMid = doorX + doorWidth / 2;

        g.setColor(new Color(254, 254, 0));
        g.fillRect(width / 5, triBase, 3 * (width / 5), rectHeight);
        g.setColor(new Color(255, 0, 0));
        g.fillRect(doorX, doorY - 40, doorWidth, 40);
        g.setColor(new Color(0, 112, 192));
        g.fillRect(doorX, doorY, doorWidth, doorHeight);

        g.setColor(Color.black);
        // house
        g.drawRect(width / 5, triBase, 3 * (width / 5), rectHeight);
        // door
        g.drawRect(doorX, doorY, doorWidth, doorHeight);
        // door red top
        g.drawRect(doorX, doorY - 40, doorWidth, 40);
        // door middle line
        g.drawLine(doorMid, doorY, doorMid, height);
    }
}
