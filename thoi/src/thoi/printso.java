package thoi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class printso extends JFrame {
    private JTextField txtSo1, txtSo2;
    private JButton btnSapXep;
    private JLabel lblKetQua;

    public printso() {
        setTitle("Sắp xếp 2 số theo thứ tự tăng dần");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        txtSo1 = new JTextField();
        txtSo2 = new JTextField();
        btnSapXep = new JButton("Sắp xếp");
        lblKetQua = new JLabel("Kết quả: ", SwingConstants.CENTER);

        add(new JLabel("Nhập số thứ nhất:"));
        add(txtSo1);
        add(new JLabel("Nhập số thứ hai:"));
        add(txtSo2);
        add(btnSapXep);
        add(lblKetQua);

        btnSapXep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double so1 = Double.parseDouble(txtSo1.getText());
                    double so2 = Double.parseDouble(txtSo2.getText());
                    String ketQua;

                    if (so1 <= so2) {
                        ketQua = so1 + ", " + so2;
                    } else {
                        ketQua = so2 + ", " + so1;
                    }

                    lblKetQua.setText("Tăng dần: " + ketQua);
                } catch (NumberFormatException ex) {
                    lblKetQua.setText("Vui lòng nhập số hợp lệ!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new printso().setVisible(true);
        });
    }
}
