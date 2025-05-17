package gj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class solonnhat extends JFrame implements ActionListener {
    private JTextField txtSo1, txtSo2, txtSo3, txtKetQua;
    private JButton btnTim;

    public solonnhat() {
        setTitle("Tìm số lớn nhất");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 5, 5));

        add(new JLabel("Nhập số thứ nhất:"));
        txtSo1 = new JTextField();
        add(txtSo1);

        add(new JLabel("Nhập số thứ hai:"));
        txtSo2 = new JTextField();
        add(txtSo2);

        add(new JLabel("Nhập số thứ ba:"));
        txtSo3 = new JTextField();
        add(txtSo3);

        btnTim = new JButton("Tìm số lớn nhất");
        btnTim.addActionListener(this);
        add(btnTim);

        txtKetQua = new JTextField();
        txtKetQua.setEditable(false);
        add(txtKetQua);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double so1 = Double.parseDouble(txtSo1.getText());
            double so2 = Double.parseDouble(txtSo2.getText());
            double so3 = Double.parseDouble(txtSo3.getText());

            double max = Math.max(so1, Math.max(so2, so3));
            txtKetQua.setText("Số lớn nhất là: " + max);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new solonnhat();
    }
}