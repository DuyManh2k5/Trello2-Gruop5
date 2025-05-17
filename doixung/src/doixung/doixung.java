package doixung;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class doixung extends JFrame {
    private JTextField txtNumber;
    private JButton btnCheck;
    private JLabel lblResult;

    public doixung() {
        // Thiết lập frame
        setTitle("Kiểm Tra Số Đối Xứng");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel đầu vào
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        inputPanel.add(new JLabel("Nhập số cần kiểm tra:"));
        txtNumber = new JTextField(15);
        inputPanel.add(txtNumber);

        // Panel button
        JPanel buttonPanel = new JPanel();
        btnCheck = new JButton("Kiểm tra đối xứng");
        btnCheck.setBackground(new Color(70, 130, 180));
        btnCheck.setForeground(Color.WHITE);
        buttonPanel.add(btnCheck);

        // Panel kết quả
        JPanel resultPanel = new JPanel();
        lblResult = new JLabel(" ");
        lblResult.setFont(new Font("Arial", Font.BOLD, 14));
        resultPanel.add(lblResult);

        // Thêm các panel vào frame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);

        // Xử lý sự kiện nút kiểm tra
        btnCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkPalindrome();
            }
        });

        // Xử lý sự kiện nhấn Enter trong text field
        txtNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkPalindrome();
            }
        });
    }

    private void checkPalindrome() {
        try {
            String numberStr = txtNumber.getText().trim();
            
            if (numberStr.isEmpty()) {
                lblResult.setText("Vui lòng nhập số cần kiểm tra!");
                lblResult.setForeground(Color.RED);
                return;
            }

            // Kiểm tra xem có phải là số không
            try {
                Long.parseLong(numberStr);
            } catch (NumberFormatException ex) {
                lblResult.setText("Vui lòng nhập số hợp lệ!");
                lblResult.setForeground(Color.RED);
                return;
            }

            boolean isPalindrome = true;
            int length = numberStr.length();
            
            for (int i = 0; i < length / 2; i++) {
                if (numberStr.charAt(i) != numberStr.charAt(length - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) {
                lblResult.setText(numberStr + " là số đối xứng");
                lblResult.setForeground(new Color(0, 100, 0)); // Màu xanh đậm
            } else {
                lblResult.setText(numberStr + " không phải số đối xứng");
                lblResult.setForeground(Color.RED);
            }
        } catch (Exception ex) {
            lblResult.setText("Đã xảy ra lỗi khi kiểm tra!");
            lblResult.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                doixung frame = new doixung();
                frame.setVisible(true);
            }
        });
    }
}
