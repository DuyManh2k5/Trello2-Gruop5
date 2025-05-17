package bscnn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bscnn extends JFrame {
    private JTextField txtA, txtB;
    private JButton btnCalculate;
    private JLabel lblResult;

    public bscnn() {
        // Thiết lập frame
        setTitle("Tìm Bội Số Chung Nhỏ Nhất");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel tiêu đề
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("TÌM BỘI SỐ CHUNG NHỎ NHẤT");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(new Color(0, 102, 204));
        titlePanel.add(titleLabel);

        // Panel đầu vào
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        inputPanel.add(new JLabel("Nhập số thứ nhất:"));
        txtA = new JTextField();
        inputPanel.add(txtA);
        
        inputPanel.add(new JLabel("Nhập số thứ hai:"));
        txtB = new JTextField();
        inputPanel.add(txtB);

        // Panel button
        JPanel buttonPanel = new JPanel();
        btnCalculate = new JButton("Tìm BSCNN");
        btnCalculate.setBackground(new Color(0, 153, 76));
        btnCalculate.setForeground(Color.WHITE);
        btnCalculate.setFont(new Font("Arial", Font.BOLD, 12));
        buttonPanel.add(btnCalculate);

        // Panel kết quả
        JPanel resultPanel = new JPanel();
        resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        lblResult = new JLabel("Kết quả sẽ hiển thị ở đây");
        lblResult.setFont(new Font("Arial", Font.BOLD, 14));
        resultPanel.add(lblResult);

        // Thêm các panel vào frame
        add(titlePanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(resultPanel, BorderLayout.PAGE_END);

        // Xử lý sự kiện nút tính toán
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateLCM();
            }
        });

        // Xử lý sự kiện nhấn Enter trong text field
        txtA.addActionListener(e -> calculateLCM());
        txtB.addActionListener(e -> calculateLCM());
    }

    private void calculateLCM() {
        try {
            int a = Integer.parseInt(txtA.getText().trim());
            int b = Integer.parseInt(txtB.getText().trim());
            
            if (a == 0 || b == 0) {
                lblResult.setText("BSCNN của 0 và một số là 0");
                lblResult.setForeground(new Color(255, 153, 0));
                return;
            }
            
            // Tính BSCNN dựa trên USCLN
            int lcm = Math.abs(a * b) / findGCD(a, b);
            
            lblResult.setText("BSCNN của " + a + " và " + b + " là: " + lcm);
            lblResult.setForeground(new Color(0, 102, 0));
        } catch (NumberFormatException ex) {
            lblResult.setText("Vui lòng nhập số nguyên hợp lệ!");
            lblResult.setForeground(Color.RED);
        }
    }

    // Hàm tìm ước số chung lớn nhất (USCLN)
    private int findGCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                bscnn frame = new bscnn();
                frame.setVisible(true);
            }
        });
    }
}
