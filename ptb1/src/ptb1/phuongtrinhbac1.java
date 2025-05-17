package ptb1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class phuongtrinhbac1 extends JFrame {
    private JTextField txtA, txtB, txtX;

    public phuongtrinhbac1() {
        setTitle("Giải Phương Trình Bậc 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(360, 300);
        setLocationRelativeTo(null); // căn giữa màn hình :contentReference[oaicite:2]{index=2}

        JPanel panel = new JPanel();
        panel.setLayout(null);        // đặt vị trí tuyệt đối như mẫu :contentReference[oaicite:3]{index=3}

        // Tiêu đề
        JLabel lblTitle = new JLabel("Giải phương trình ax + b = 0");
        lblTitle.setFont(new Font("Arial", Font.ITALIC, 18));
        lblTitle.setForeground(Color.RED);
        lblTitle.setBounds(50, 10, 260, 30);
        panel.add(lblTitle);

        // Nhãn và ô nhập hệ số a
        JLabel lblA = new JLabel("a :");
        lblA.setBounds(30, 60, 60, 25);
        panel.add(lblA);

        txtA = new JTextField();
        txtA.setBounds(80, 60, 200, 25);  // theo hướng dẫn JTextField(cols) :contentReference[oaicite:4]{index=4}
        panel.add(txtA);

        // Nhãn và ô nhập hệ số b
        JLabel lblB = new JLabel("b :");
        lblB.setBounds(30, 100, 60, 25);
        panel.add(lblB);

        txtB = new JTextField();
        txtB.setBounds(80, 100, 200, 25);
        panel.add(txtB);

        // Nhãn và ô hiển thị nghiệm x
        JLabel lblX = new JLabel("x =");
        lblX.setBounds(30, 140, 60, 25);
        panel.add(lblX);

        txtX = new JTextField();
        txtX.setEditable(false);
        txtX.setBounds(80, 140, 200, 25);
        panel.add(txtX);

        // Nút Giải
        JButton btnSolve = new JButton("Giải");
        btnSolve.setBounds(80, 190, 80, 30);
        panel.add(btnSolve);

        // Nút Thoát
        JButton btnExit = new JButton("Thoát");
        btnExit.setForeground(Color.RED);
        btnExit.setBounds(200, 190, 80, 30);
        panel.add(btnExit);

        // Xử lý sự kiện nút “Giải”
        btnSolve.addActionListener((ActionEvent e) -> {
            try {
                double a = Double.parseDouble(txtA.getText().trim());
                double b = Double.parseDouble(txtB.getText().trim());
                if (a == 0) {
                    JOptionPane.showMessageDialog(
                        this, "Hệ số a phải khác 0!", "Lỗi dữ liệu",
                        JOptionPane.ERROR_MESSAGE
                    );
                } else {
                    double x = -b / a;
                    txtX.setText(String.format("%.4f", x));
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                    this, "Vui lòng nhập số hợp lệ!", "Lỗi định dạng",
                    JOptionPane.ERROR_MESSAGE
                ); // sử dụng JOptionPane :contentReference[oaicite:5]{index=5}
            }
        });

        // Xử lý sự kiện nút “Thoát”
        btnExit.addActionListener(evt -> System.exit(0));

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(phuongtrinhbac1::new); // khởi chạy trên EDT :contentReference[oaicite:6]{index=6}
    }
}
