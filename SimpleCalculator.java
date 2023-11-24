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
    Button nPr = new Button("nPr");
    Button nCr = new Button("nCr");
    
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
        
        frame.setLayout(null);
        frame.setSize(400, 350);
        frame.setVisible(true);
    }
    
    public int exit() {
        System.exit(0);
        return 0;
    }
    
    private int fac(int n) {
        int prod = 1;
        for (int i = 1; i <= n; i++) {
            prod *= i;
        }
        return prod;
    }
    
    public void actionPerformed(ActionEvent e) {
        BigDecimal a = new BigDecimal(num1.getText());
        BigDecimal b = new BigDecimal(num2.getText());
        double a_doub = a.doubleValue();
        double b_doub = b.doubleValue();

        result.setText(String.valueOf(
            e.getSource() == plus ? a.add(b)
            : e.getSource() == minus ? a.subtract(b)
            : e.getSource() == times ? a.multiply(b)
            : e.getSource() == divide ? a_doub / b_doub
            : e.getSource() == pow ? Math.pow(a_doub, b_doub)
            : e.getSource() == root ? Math.pow(a_doub, 1 / b_doub)
            : e.getSource() == log ? Math.log(b_doub) / Math.log(a_doub)
            : exit()
        ));
    }
    
    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
