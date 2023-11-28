import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;

public class SimpleCalculator implements ActionListener {
    Frame frame = new Frame("Simple Calculator");

    Label label1 = new Label("Num 1: (a)");
    Label label2 = new Label("Num 2: (b)");
    Label label3 = new Label("Result");

    TextField num1 = new TextField();
    TextField num2 = new TextField();
    TextField result = new TextField();

    Button plus = new Button("+");
    Button minus = new Button("-");
    Button times = new Button("×");
    Button divide = new Button("÷");
    Button resetButton = new Button("CE");

    Button pow = new Button("a^b");
    Button root = new Button("a√b");
    Button log = new Button("log_a(b)");
    Button gcd = new Button("gcd");
    Button lcm = new Button("lcm");

    Button mod = new Button("mod");
    Button nPr = new Button("nPr");
    Button nCr = new Button("nCr");
    
    Button[][] buttons = {
        {plus, minus, times, divide, resetButton},
        {pow, root, log, gcd, lcm},
        {mod, nPr, nCr},
    };
    
    static final int buttonWidth = 60;
    static final int buttonHeight = 20;
    static final int gap = 10;

    public SimpleCalculator() {
        int x = 50, y = 250;
        for (Button[] row : buttons) {
            for (Button button : row) {
                button.setBounds(x, y, buttonWidth, buttonHeight);
                button.addActionListener(this);
                frame.add(button);
                x += buttonWidth + gap;
            }
            x = 50;
            y += buttonHeight + gap;
        }
        
        label1.setBounds(50, 100, 100, 20);
        label2.setBounds(50, 140, 100, 20);
        label3.setBounds(50, 180, 100, 20);

        num1.setBounds(200, 100, 100, 20);
        num2.setBounds(200, 140, 100, 20);
        result.setBounds(200, 180, 100, 20);

        frame.add(label1);
        frame.add(label2);
        frame.add(label3);

        frame.add(num1);
        frame.add(num2);
        frame.add(result);
        
        frame.addWindowListener(
            new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        
        frame.setBackground(new Color(200, 200, 200));
        frame.setLayout(null);
        frame.setSize(400, 350);
        frame.setVisible(true);
    }

    private int reset() {
        num1.setText("");
        num2.setText("");
        result.setText("");
        return 0;
    }

    private static long fac(long n) {
        long prod = 1;
        for (int i = 1; i <= n; i++) {
            prod *= i;
        }
        return prod;
    }

    private static double gcd(double a, double b) {
        return b == 0
            ? a
            : gcd(b, a % b);
    }

    private static double lcm(double a, double b) {
        return (a * b) / gcd(a, b);
    }

    private static long permutations(double n_doub, double k_doub) {
        long n = Math.round(n_doub);
        long k = Math.round(k_doub);
        return fac(n) / fac(n - k);
    }

    private static long combinations(double n_doub, double k_doub) {
        long n = Math.round(n_doub);
        long k = Math.round(k_doub);
        return fac(n) / (fac(k) * fac(n - k));
    }

    public void actionPerformed(ActionEvent e) {
        try {
            var src = e.getSource();
            if (src == resetButton) {
                reset();
                return;
            }
            
            BigDecimal a = new BigDecimal(num1.getText());
            BigDecimal b = new BigDecimal(num2.getText());
            double a_doub = a.doubleValue();
            double b_doub = b.doubleValue();

            result.setText(String.valueOf(
                src == plus ? a.add(b)
                : src == minus ? a.subtract(b)
                : src == times ? a.multiply(b)
                : src == divide ? a_doub / b_doub
                : src == pow ? Math.pow(a_doub, b_doub)
                : src == root ? Math.pow(a_doub, 1 / b_doub)
                : src == log ? Math.log(b_doub) / Math.log(a_doub)
                : src == gcd ? gcd(a_doub, b_doub)
                : src == lcm ? lcm(a_doub, b_doub)
                : src == mod ? a_doub % b_doub
                : src == nPr ? permutations(a_doub, b_doub)
                : src == nCr ? combinations(a_doub, b_doub)
                : ""
            ));
        } catch(Exception err) {
            result.setText("Syntax Error");
            return;
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
