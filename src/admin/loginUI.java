package admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class loginUI extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPanel contentPane;

    public loginUI() {
        setTitle("Admin Login");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);

        JPanel loginPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = loadImage("/resources/ImageIcon/bglog.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        loginPanel.setPreferredSize(new Dimension(450, 600));
        loginPanel.setLayout(null);
        contentPane.add(loginPanel, BorderLayout.WEST);

        // Login Label
        JLabel loginLabel = new JLabel("LOG IN");
        loginLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
        loginLabel.setForeground(Color.WHITE);
        loginLabel.setBounds(149, 100, 115, 40);
        loginPanel.add(loginLabel);

        // Email Label and Text Field
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Sitka Text", Font.PLAIN, 22));
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setBounds(100, 180, 100, 30);
        loginPanel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBackground(new Color(221, 221, 221));
        emailField.setBounds(100, 210, 200, 30);
        loginPanel.add(emailField);

        // Password Label and Password Field
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Sitka Text", Font.PLAIN, 22));
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(100, 260, 100, 30);
        loginPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBackground(new Color(221, 221, 221));
        passwordField.setBounds(100, 290, 200, 30);
        loginPanel.add(passwordField);

        // Login Button
        JButton loginButton = new JButton("");
        loginButton.setBounds(154, 355, 95, 30);
        ImageIcon arrowIcon = loadImage("/resources/ImageIcon/buton.png");
        loginButton.setIcon(arrowIcon);
        loginPanel.add(loginButton);

        // Add Action Listener to Login Button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAdminLogin();
            }
        });

        // Right-side Image Panel
        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon rightSideImage = loadImage("/resources/ImageIcon/hotel6.png");
                g.drawImage(rightSideImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.add(imagePanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void handleAdminLogin() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        if (validateAdminLogin(email, password)) {
            boolean isMainAdmin = checkIfMainAdmin(email);

            if (isMainAdmin) {
                JOptionPane.showMessageDialog(this, "Welcome, Main Admin! Redirecting to Admin Dashboard with elevated permissions.");
            } else {
                JOptionPane.showMessageDialog(this, "Login Successful! Welcome to the Admin Dashboard.");
            }

            openAdminDashboard(email, isMainAdmin);
            dispose(); // Close login window
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Email or Password!", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validateAdminLogin(String email, String password) {
        String dbURL = "jdbc:mysql://127.0.0.1:3306/hotel";
        String dbUsername = "root";
        String dbPassword = "11211810jr";

        try (Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword)) {
            String sql = "SELECT * FROM users WHERE email = ? AND password = ? AND (role = 'admin' OR super_admin = TRUE)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, email);
                stmt.setString(2, password);

                try (ResultSet rs = stmt.executeQuery()) {
                    return rs.next();
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteUser(String username) {
        String sql = "DELETE FROM users WHERE username = ? AND super_admin = FALSE";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hotel", "root", "11211810jr");
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean validateMainAdminLogin(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ? AND super_admin = TRUE";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hotel", "root", "11211810jr");
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateUserRole(String username, String newRole) {
        String sql = "UPDATE users SET role = ? WHERE username = ? AND super_admin = FALSE";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hotel", "root", "11211810jr");
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newRole);
            stmt.setString(2, username);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean checkIfMainAdmin(String email) {
        String dbURL = "jdbc:mysql://127.0.0.1:3306/hotel";
        String dbUsername = "root";
        String dbPassword = "11211810jr";

        try (Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword)) {
            String sql = "SELECT super_admin FROM users WHERE email = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, email);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getBoolean("super_admin");
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
        }
        return false;
    }

    private void openAdminDashboard(String email, boolean isMainAdmin) {
        AdminDashboard dashboard = new AdminDashboard(email);
        dashboard.setVisible(true);
    }

    private ImageIcon loadImage(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Error: Couldn't find file: " + path);
            return new ImageIcon();
        }
    }

    public static void main(String[] args) {
        new loginUI();
    }
}
