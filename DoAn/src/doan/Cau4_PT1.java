package doan_sanh;

import javax.swing.*;
import java.awt.event.*;

public class Cau4_PT1 extends JFrame implements ActionListener {
    JTextField a, b;
    JLabel kq;

    public Cau4_PT1() {
        setTitle("Câu 4");
        setSize(300, 200);
        setLayout(null);

        add(new JLabel("a:")).setBounds(20, 20, 50, 25);
        a = new JTextField(); a.setBounds(100, 20, 100, 25); add(a);

        add(new JLabel("b:")).setBounds(20, 60, 50, 25);
        b = new JTextField(); b.setBounds(100, 60, 100, 25); add(b);

        JButton btn = new JButton("Giải");
        btn.setBounds(80, 100, 100, 30);
        btn.addActionListener(this);
        add(btn);

        kq = new JLabel("");
        kq.setBounds(20, 140, 250, 25);
        add(kq);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double A = Double.parseDouble(a.getText());
        double B = Double.parseDouble(b.getText());

        if (A == 0) {
            if (B == 0) kq.setText("Vô số nghiệm");
            else kq.setText("Vô nghiệm");
        } else {
            kq.setText("x = " + (-B / A));
        }
    }

    public static void main(String[] args) {
        new Cau4_PT1();
    }
}