package doan_sanh;

import javax.swing.*;
import java.awt.event.*;

public class Cau3_MayTinh extends JFrame implements ActionListener {
    JTextField a, b, op;
    JLabel kq;

    public Cau3_MayTinh() {
        setTitle("Câu 3");
        setSize(300, 250);
        setLayout(null);

        add(new JLabel("a:")).setBounds(20, 20, 50, 25);
        a = new JTextField(); a.setBounds(100, 20, 100, 25); add(a);

        add(new JLabel("b:")).setBounds(20, 60, 50, 25);
        b = new JTextField(); b.setBounds(100, 60, 100, 25); add(b);

        add(new JLabel("Phép tính:")).setBounds(20, 100, 80, 25);
        op = new JTextField(); op.setBounds(100, 100, 100, 25); add(op);

        JButton btn = new JButton("Tính");
        btn.setBounds(80, 140, 100, 30);
        btn.addActionListener(this);
        add(btn);

        kq = new JLabel("");
        kq.setBounds(20, 180, 250, 25);
        add(kq);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double x = Double.parseDouble(a.getText());
        double y = Double.parseDouble(b.getText());
        String o = op.getText();

        double res = 0;

        switch (o) {
            case "+": res = x + y; break;
            case "-": res = x - y; break;
            case "*": res = x * y; break;
            case "/": res = y != 0 ? x / y : 0; break;
        }

        kq.setText("KQ: " + res);
    }

    public static void main(String[] args) {
        new Cau3_MayTinh();
    }
}
