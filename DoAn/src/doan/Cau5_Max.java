package doan_sanh;
	import javax.swing.*;
	import java.awt.event.*;

	public class Cau5_Max extends JFrame implements ActionListener {
	    JTextField a, b, c;
	    JLabel kq;

	    public Cau5_Max() {
	        setTitle("Câu 5");
	        setSize(300, 250);
	        setLayout(null);

	        a = new JTextField(); a.setBounds(100, 20, 100, 25); add(a);
	        b = new JTextField(); b.setBounds(100, 60, 100, 25); add(b);
	        c = new JTextField(); c.setBounds(100, 100, 100, 25); add(c);

	        add(new JLabel("a:")).setBounds(20, 20, 50, 25);
	        add(new JLabel("b:")).setBounds(20, 60, 50, 25);
	        add(new JLabel("c:")).setBounds(20, 100, 50, 25);

	        JButton btn = new JButton("Tìm");
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
	        double z = Double.parseDouble(c.getText());

	        double max = Math.max(x, Math.max(y, z));
	        kq.setText("Max: " + max);
	    }

	    public static void main(String[] args) {
	        new Cau5_Max();
	    }
	}