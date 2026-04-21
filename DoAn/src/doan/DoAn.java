package doan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DoAn extends JFrame implements ActionListener {

    private JTextField txtA, txtB, txtC;
    private JButton btnGiai;
    private JTextArea txtKetQua;

    public DoAn() {
        setTitle("Giải phương trình bậc 2");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelInput = new JPanel(new GridLayout(3, 2));

        panelInput.add(new JLabel("a:"));
        txtA = new JTextField();
        panelInput.add(txtA);

        panelInput.add(new JLabel("b:"));
        txtB = new JTextField();
        panelInput.add(txtB);

        panelInput.add(new JLabel("c:"));
        txtC = new JTextField();
        panelInput.add(txtC);

        btnGiai = new JButton("Giải");
        btnGiai.addActionListener(this);

        txtKetQua = new JTextArea();
        txtKetQua.setEditable(false);

        add(panelInput, BorderLayout.NORTH);
        add(btnGiai, BorderLayout.CENTER);
        add(txtKetQua, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double c = Double.parseDouble(txtC.getText());

            txtKetQua.setText(giaiPT(a, b, c));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Nhập sai!");
        }
    }

}
