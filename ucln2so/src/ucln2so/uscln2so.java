package ucln2so;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class uscln2so extends JFrame {
    private JTextField txtA, txtB, txtGcd;

    public uscln2so() {
        setTitle("Tìm USCLN của 2 số");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(360, 300);
        setLocationRelativeTo(null);
        setLayout(null);  // không dùng LayoutManager :contentReference[oaicite:4]{index=4}

        // Tiêu đề
        JLabel lblTitle = new JLabel("Tính USCLN (GCD) của 2 số");
        lblTitle.setFont(new Font("Arial", Font.ITALIC, 18));
        lblTitle.setForeground(Color.RED);
        lblTitle.setBounds(60, 10, 300, 30);
        add(lblTitle);

        // Nhãn và ô nhập Số a
        JLabel lblA = new JLabel("Số a :");
        lblA.setBounds(30, 60, 80, 25);
        add(lblA);

        txtA = new JTextField();
        txtA.setBounds(120, 60, 160, 25);  // vị trí và kích thước thủ công :contentReference[oaicite:5]{index=5}
        add(txtA);

        // Nhãn và ô nhập Số b
        JLabel lblB = new JLabel("Số b :");
        lblB.setBounds(30, 100, 80, 25);
        add(lblB);

        txtB = new JTextField();
        txtB.setBounds(120, 100, 160, 25);
        add(txtB);

        // Nhãn và ô hiển thị USCLN
        JLabel lblGcd = new JLabel("USCLN :");
        lblGcd.setBounds(30, 140, 80, 25);
        add(lblGcd);

        txtGcd = new JTextField();
        txtGcd.setEditable(false);
        txtGcd.setBounds(120, 140, 160, 25);
        add(txtGcd);

        // Nút Tính
        JButton btnCalc = new JButton("Tính");
        btnCalc.setBounds(80, 190, 80, 30);
        add(btnCalc);

        // Nút Thoát
        JButton btnExit = new JButton("Thoát");
        btnExit.setForeground(Color.RED);
        btnExit.setBounds(180, 190, 80, 30);
        add(btnExit);

        // Sự kiện Tính USCLN
        btnCalc.addActionListener((ActionEvent e) -> {
            try {
                int a = Integer.parseInt(txtA.getText().trim());
                int b = Integer.parseInt(txtB.getText().trim());
                if (a < 0 || b < 0) {
                    JOptionPane.showMessageDialog(this,
                        "Vui lòng nhập số không âm!", "Lỗi dữ liệu",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int result = gcd(a, b);
                txtGcd.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                    "Vui lòng nhập số nguyên hợp lệ!", "Lỗi định dạng",
                    JOptionPane.ERROR_MESSAGE);
            }
        });

        // Sự kiện Thoát
        btnExit.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    /** 
     * Tính USCLN theo thuật toán Euclid (Euclidean algorithm) 
     * dựa trên ví dụ từ Stack Overflow :contentReference[oaicite:6]{index=6}
     */
    private int gcd(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        while (y != 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(uscln2so::new);
    }
}
