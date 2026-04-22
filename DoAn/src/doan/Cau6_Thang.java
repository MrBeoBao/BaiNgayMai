package doan_sanh;

import javax.swing.*;
import java.awt.event.*;

public class Cau6_Thang extends JFrame implements ActionListener {
    JTextField thang, nam;
    JLabel kq;

    public Cau6_Thang() {
        setTitle("Câu 6");
        setSize(300, 250);
        setLayout(null);

        thang = new JTextField(); thang.setBounds(100, 20, 100, 25); add(thang);
        nam = new JTextField(); nam.setBounds(100, 60, 100, 25); add(nam);

        add(new JLabel("Tháng:")).setBounds(20, 20, 80, 25);
        add(new JLabel("Năm:")).setBounds(20, 60, 80, 25);

        JButton btn = new JButton("Xem");
        btn.setBounds(80, 100, 100, 30);
        btn.addActionListener(this);
        add(btn);

        kq = new JLabel("");
        kq.setBounds(20, 140, 250, 25);
        add(kq);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int m = Integer.parseInt(thang.getText());
        int y = Integer.parseInt(nam.getText());

        int days = 31;

        if (m == 2) {
            days = (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) ? 29 : 28;
        } else if (m == 4 || m == 6 || m == 9 || m == 11) {
            days = 30;
        }

        kq.setText("Số ngày: " + days);
    }

    public static void main(String[] args) {
        new Cau6_Thang();
    }
}