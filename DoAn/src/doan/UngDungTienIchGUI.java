package doan_sanh;

import javax.swing.*;
import java.awt.*;

public class UngDungTienIchGUI extends JFrame {

    // Khai báo thành phần cho Diện tích
    private JTextField txtChieuDai, txtChieuRong, txtKetQuaDT;
    // Khai báo thành phần cho Taxi
    private JTextField txtSoKm, txtThanhTienTaxi;

    public UngDungTienIchGUI() {
        setTitle("Ứng dụng Đa năng: Diện tích & Taxi");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // --- PHẦN 1: TÍNH DIỆN TÍCH ---
        JPanel pnlDienTich = createSectionPanel("1. Tính Diện Tích Hình Chữ Nhật");
        pnlDienTich.setLayout(new GridLayout(4, 2, 5, 5));
        
        txtChieuDai = new JTextField();
        txtChieuRong = new JTextField();
        txtKetQuaDT = new JTextField();
        txtKetQuaDT.setEditable(false);
        txtKetQuaDT.setBackground(Color.LIGHT_GRAY);

        JButton btnTinhDT = new JButton("Tính Diện Tích");
        btnTinhDT.addActionListener(e -> tinhDienTich());

        pnlDienTich.add(new JLabel(" Chiều dài:")); pnlDienTich.add(txtChieuDai);
        pnlDienTich.add(new JLabel(" Chiều rộng:")); pnlDienTich.add(txtChieuRong);
        pnlDienTich.add(new JLabel(" Kết quả:")); pnlDienTich.add(txtKetQuaDT);
        pnlDienTich.add(new JLabel("")); pnlDienTich.add(btnTinhDT);

        // --- PHẦN 2: TÍNH TIỀN TAXI ---
        JPanel pnlTaxi = createSectionPanel("2. Tính Tiền Taxi");
        pnlTaxi.setLayout(new GridLayout(3, 2, 5, 5));

        txtSoKm = new JTextField();
        txtThanhTienTaxi = new JTextField();
        txtThanhTienTaxi.setEditable(false);
        txtThanhTienTaxi.setBackground(new Color(220, 240, 220)); // Màu xanh nhạt cho tiền

        JButton btnTinhTaxi = new JButton("Tính Tiền Taxi");
        btnTinhTaxi.addActionListener(e -> tinhTienTaxi());

        pnlTaxi.add(new JLabel(" Nhập số KM:")); pnlTaxi.add(txtSoKm);
        pnlTaxi.add(new JLabel(" Thành tiền (VNĐ):")); pnlTaxi.add(txtThanhTienTaxi);
        pnlTaxi.add(new JLabel("")); pnlTaxi.add(btnTinhTaxi);

        // Thêm các Panel vào Frame
        add(pnlDienTich);
        add(new JSeparator()); // Đường kẻ ngang phân cách
        add(pnlTaxi);
    }

    // Logic tính Tiền Taxi
    private void tinhTienTaxi() {
        try {
            double km = Double.parseDouble(txtSoKm.getText());

            if (km < 0) {
                JOptionPane.showMessageDialog(this, "Thông báo: Nhập dữ liệu sai (KM phải >= 0)", "Lỗi", JOptionPane.ERROR_MESSAGE);
                txtThanhTienTaxi.setText("");
            } else {
                double tien = km * 10000;
                // Định dạng hiển thị số tiền cho đẹp
                txtThanhTienTaxi.setText(String.format("%,.0f", tien));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số KM hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Logic tính Diện tích (giữ nguyên từ bài trước)
    private void tinhDienTich() {
        try {
            double dai = Double.parseDouble(txtChieuDai.getText());
            double rong = Double.parseDouble(txtChieuRong.getText());
            if (dai <= 0 || rong <= 0) {
                JOptionPane.showMessageDialog(this, "Kích thước phải > 0");
            } else {
                txtKetQuaDT.setText(String.valueOf(dai * rong));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Nhập số không hợp lệ!");
        }
    }

    // Hàm phụ tạo Border cho từng phần
    private JPanel createSectionPanel(String title) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(title));
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UngDungTienIchGUI().setVisible(true));
    }
}
