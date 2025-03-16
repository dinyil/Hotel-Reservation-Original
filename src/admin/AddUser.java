package admin;

import javax.swing.*;

import at.favre.lib.crypto.bcrypt.BCrypt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddUser extends JFrame {

    private JTextField emailField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JRadioButton adminRadioButton;
    private JRadioButton employeeRadioButton;
    private UserManagementOptions optionsWindow;

    public AddUser(UserManagementOptions optionsWindow) {
        getContentPane().setBackground(new Color(240, 240, 240));
        this.optionsWindow = optionsWindow;
        setTitle("Add User");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        emailLabel.setBounds(66, 97, 80, 25);
        getContentPane().add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(177, 97, 252, 25);
        getContentPane().add(emailField);

        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        usernameLabel.setBounds(66, 135, 80, 25);
        getContentPane().add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(177, 135, 252, 25);
        getContentPane().add(usernameField);

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        passwordLabel.setBounds(66, 173, 80, 25);
        getContentPane().add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(177, 173, 252, 25);
        getContentPane().add(passwordField);

        adminRadioButton = new JRadioButton("Admin");
        adminRadioButton.setBounds(177, 211, 80, 25);
        getContentPane().add(adminRadioButton);

        employeeRadioButton = new JRadioButton("Employee");
        employeeRadioButton.setBounds(329, 211, 100, 25);
        getContentPane().add(employeeRadioButton);

        ButtonGroup roleGroup = new ButtonGroup();
        roleGroup.add(adminRadioButton);
        roleGroup.add(employeeRadioButton);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBackground(new Color(247, 170, 43));
        confirmButton.setBounds(197, 262, 197, 39);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleConfirm();  // Call method to handle form submission
            }
        });
        getContentPane().add(confirmButton);

        // Back Button to return to UserManagementOptions
        JButton backButton = new JButton("Back");
        backButton.setForeground(new Color(255, 255, 255));
        backButton.setBackground(new Color(0, 64, 128));
        backButton.setBounds(12, 309, 91, 39);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current window
                optionsWindow.setVisible(true); // Show the options window
            }
        });
        getContentPane().add(backButton);

        JLabel lblAddUser = new JLabel("ADD USER");
        lblAddUser.setForeground(new Color(0, 64, 128));
        lblAddUser.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 40));
        lblAddUser.setBounds(217, 29, 170, 39);
        getContentPane().add(lblAddUser);

        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 564, 339);
        getContentPane().add(panel);
    }

    private void handleConfirm() {
        String email = emailField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String role = adminRadioButton.isSelected() ? "admin" : "employee";

        String hashedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());

        // Add user to the database
        addUserToDatabase(username, email, hashedPassword, role);

        // Optionally, clear the fields after submission
        emailField.setText("");
        usernameField.setText("");
        passwordField.setText("");
        adminRadioButton.setSelected(false);
        employeeRadioButton.setSelected(false);
    }

    public void addUserToDatabase(String username, String email, String password, String role) {
        String dbURL = "jdbc:mysql://127.0.0.1:3306/hotel";
        String dbUsername = "root";
        String dbPassword = "11211810jr";

        try (Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword)) {
            String sql = "INSERT INTO users (username, email, password, role) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, email);
                stmt.setString(3, password);
                stmt.setString(4, role);

                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "User added successfully!");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error adding user: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Dummy AdminDashboard for demonstration purposes
        AdminDashboard dashboard = new AdminDashboard(null);
        UserManagementOptions optionsWindow = new UserManagementOptions(dashboard); // Create the main options window
        optionsWindow.setVisible(true); // Show the UserManagementOptions window
    }
}
