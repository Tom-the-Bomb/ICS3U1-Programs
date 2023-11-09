import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovingBall extends JPanel implements ActionListener {
    int x = 0;
    int y = 0;
    Timer timer = new Timer(10, this);
    
    int velX = 2; // x-velocity px/s
    int velY = 3; // y-velocity px/s
    
    static int width = 500; // width of box
    static int height = 400; // height of box
    static int rad = 50; // radius of ball
    
    public static void main(String[] args) {
        MovingBall movingBall = new MovingBall();
        JFrame frame = new JFrame("Animation");
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(movingBall);
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.drawRect(0, 0, width, height);
        
        g.setColor(Color.red);
        g.fillOval(x, y, rad, rad);
        timer.start();
    }
    
    public void actionPerformed(ActionEvent event) {
        x += velX;
        y += velY;
        repaint();
        
        if (x >= width - rad || x <= 0) {
            velX *= -1;
        }
        if (y >= height - rad || y <= 0) {
            velY *= -1;
        }
    }
}
