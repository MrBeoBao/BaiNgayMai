package doan_sanh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TinhDienTichGUI extends JFrame {

    // Khai báo các thành phần giao diện
    private JTextField txtChieuDai, txtChieuRong, txtKetQua;
    private JButton btnTinh, btnXoa;

    public TinhDienTichGUI() {
        // 1. Thiết lập tiêu đề và cấu hình khung cửa sổ
        setTitle("Phần mềm tính diện tích Hình Chữ Nhật");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Hiển thị giữa màn hình
        setLayout(new GridLayout(5, 2, 10, 10)); // Bố cục dạng lưới

        // 2. Tạo và thêm các thành phần vào Frame
        add(new JLabel("  Chiều dài:"));
        txtChieuDai = new JTextField();
        add(txtChieuDai);

        add(new JLabel("  Chiều rộng:"));
        txtChieuRong = new JTextField();
        add(txtChieuRong);

        add(new JLabel("  Diện tích:"));
        txtKetQua = new JTextField();
        txtKetQua.setEditable(false); // Không cho phép nhập vào ô kết quả
        txtKetQua.setBackground(Color.LIGHT_GRAY);
        add(txtKetQua);

        // Nút tính toán
        btnTinh = new JButton("Tính Diện Tích");
        add(btnTinh);

        // Nút xóa làm lại
        btnXoa = new JButton("Xóa dữ liệu");
        add(btnXoa);

        // 3. Xử lý sự kiện khi nhấn nút
        btnTinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tinhDienTich();
            }
        });

        btnXoa.addActionListener(e -> {
            txtChieuDai.setText("");
            txtChieuRong.setText("");
            txtKetQua.setText("");
        });
    }

    // Hàm logic tính toán
    private void tinhDienTich() {
        try {
            double dai = Double.parseDouble(txtChieuDai.getText());
            double rong = Double.parseDouble(txtChieuRong.getText());

            if (dai <= 0 || rong <= 0) {
                JOptionPane.showMessageDialog(this, "Kích thước phải lớn hơn 0!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double dienTich = dai * rong;
            txtKetQua.setText(String.valueOf(dienTich));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Chạy chương trình trong luồng Event Dispatch Thread để đảm bảo an toàn giao diện
        SwingUtilities.invokeLater(() -> {
            new TinhDienTichGUI().setVisible(true);
        });
    }
}
