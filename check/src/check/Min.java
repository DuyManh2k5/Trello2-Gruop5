package check;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Min extends JFrame {
    private JTextField txtSo1, txtSo2;
    private JButton btnTinhMin;
    private JLabel lblKetQua;

    public Min() {
        setTitle("Tìm số nhỏ nhất");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        // Tạo thành phần giao diện
        txtSo1 = new JTextField();
        txtSo2 = new JTextField();
        btnTinhMin = new JButton("Tìm số nhỏ nhất");
        lblKetQua = new JLabel("Kết quả: ", SwingConstants.CENTER);

        // Thêm thành phần vào cửa sổ
        add(new JLabel("Nhập số thứ nhất:"));
        add(txtSo1);
        add(new JLabel("Nhập số thứ hai:"));
        add(txtSo2);
        add(btnTinhMin);
        add(lblKetQua);

        // Xử lý sự kiện nút
        btnTinhMin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double so1 = Double.parseDouble(txtSo1.getText());
                    double so2 = Double.parseDouble(txtSo2.getText());
                    double min = Math.min(so1, so2);
                    lblKetQua.setText("Số nhỏ nhất: " + min);
                } catch (NumberFormatException ex) {
                    lblKetQua.setText("Vui lòng nhập số hợp lệ!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Min().setVisible(true);
        });
    }
}
