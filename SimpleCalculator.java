import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;

public class SimpleCalculator implements ActionListener
{
    Frame frame = new Frame("Simple Calculator");

    Label label1 = new Label("Num 1: a");
    Label label2 = new Label("Num 2: b");
    Label label3 = new Label("Result");

    TextField num1 = new TextField();
    TextField num2 = new TextField();
    TextField result = new TextField();

    Button plus = new Button("+");
    Button minus = new Button("-");
    Button times = new Button("×");
    Button divide = new Button("÷");
    Button cancel = new Button("Cancel");

    Button pow = new Button("a^b");
    Button root = new Button("a√b");
    Button log = new Button("log_a(b)");
    Button gcd = new Button("gcd");
    Button lcm = new Button("lcm");

    Button mod = new Button("mod");
    Button nPr = new Button("nPr(a, b)");
    Button nCr = new Button("nCr(a, b)");

    public SimpleCalculator() {
        label1.setBounds(50, 100, 100, 20);
        label2.setBounds(50, 140, 100, 20);
        label3.setBounds(50, 180, 100, 20);

        num1.setBounds(200, 100, 100, 20);
        num2.setBounds(200, 140, 100, 20);
        result.setBounds(200, 180, 100, 20);

        plus.setBounds(50, 250, 50, 20);
        minus.setBounds(110, 250, 50, 20);
        times.setBounds(170, 250, 50, 20);
        divide.setBounds(230, 250, 50, 20);
        cancel.setBounds(290, 250, 50, 20);

        pow.setBounds(50, 290, 50, 20);
        root.setBounds(110, 290, 50, 20);
        log.setBounds(170, 290, 50, 20);
        gcd.setBounds(230, 290, 50, 20);
        lcm.setBounds(290, 290, 50, 20);

        mod.setBounds(50, 330, 50, 20);
        nPr.setBounds(110, 330, 50, 20);
        nCr.setBounds(170, 330, 50, 20);

        plus.addActionListener(this);
        minus.addActionListener(this);
        times.addActionListener(this);
        divide.addActionListener(this);
        cancel.addActionListener(this);

        pow.addActionListener(this);
        root.addActionListener(this);
        log.addActionListener(this);
        gcd.addActionListener(this);
        lcm.addActionListener(this);

        mod.addActionListener(this);
        nPr.addActionListener(this);
        nCr.addActionListener(this);

        frame.add(label1);
        frame.add(label2);
        frame.add(label3);

        frame.add(num1);
        frame.add(num2);
        frame.add(result);

        frame.add(plus);
        frame.add(minus);
        frame.add(times);
        frame.add(divide);
        frame.add(cancel);

        frame.add(pow);
        frame.add(root);
        frame.add(log);
        frame.add(gcd);
        frame.add(lcm);

        frame.add(mod);
        frame.add(nPr);
        frame.add(nCr);

        frame.setLayout(null);
        frame.setSize(400, 350);
        frame.setVisible(true);
    }

    public int exit() {
        System.exit(0);
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
            BigDecimal a = new BigDecimal(num1.getText());
            BigDecimal b = new BigDecimal(num2.getText());
            double a_doub = a.doubleValue();
            double b_doub = b.doubleValue();

            var src = e.getSource();
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
                : exit()
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
