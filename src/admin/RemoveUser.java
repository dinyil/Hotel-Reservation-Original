package admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;

public class RemoveUser extends JFrame {
    private JTextField usernameField;
    private UserManagementOptions optionsWindow;  // Reference to UserManagementOptions  

    public RemoveUser(UserManagementOptions optionsWindow) {
        getContentPane().setBackground(new Color(3, 91, 150));
        this.optionsWindow = optionsWindow;  // Store reference to the options window  
        setTitle("Remove User");  // Update title to be accurate
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel usernameLabel = new JLabel("Search Username:");
        usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        usernameLabel.setBounds(66, 135, 129, 25);
        getContentPane().add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(205, 136, 308, 25);
        getContentPane().add(usernameField);

        JButton confirmButton = new JButton("Remove");
        confirmButton.setForeground(new Color(0, 0, 0));
        confirmButton.setBackground(new Color(254, 199, 54));
        confirmButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
        confirmButton.setBounds(205, 197, 197, 39);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleConfirm();  // Call method to handle the removal of a user
            }
        });
        getContentPane().add(confirmButton);

        // Back Button to return to UserManagementOptions
        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(0, 64, 128));
        backButton.setForeground(new Color(255, 255, 255));
        backButton.setBounds(22, 309, 81, 25);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current window
                optionsWindow.setVisible(true); // Show the options window
            }
        });
        getContentPane().add(backButton);
        
        JLabel lblRemoveUser = new JLabel("  REMOVE USER");
        lblRemoveUser.setForeground(new Color(0, 64, 128));
        lblRemoveUser.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 40));
        lblRemoveUser.setBounds(159, 71, 260, 34);
        getContentPane().add(lblRemoveUser);
        
        JPanel panel = new JPanel();
        panel.setBounds(12, 11, 562, 339);
        getContentPane().add(panel);
    }

    private void handleConfirm() {
        String username = usernameField.getText();

        // Logic for removing a user can be implemented here, for now, it's a mock action.
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a username.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Mock success message
            JOptionPane.showMessageDialog(this, "User removed: " + username);
            usernameField.setText("");  // Clear the field after the operation
        }
    }

    public static void main(String[] args) {
        // Create a dummy UserManagementOptions for standalone testing
        AdminDashboard dashboard = new AdminDashboard(null);
        UserManagementOptions optionsWindow = new UserManagementOptions(dashboard); // Create the main options window
        new RemoveUser(optionsWindow).setVisible(true); // Test RemoveUser independently
    }
}
