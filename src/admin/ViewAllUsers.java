package admin;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewAllUsers extends JFrame {
    private JPanel usersPanel;
    private JScrollPane scrollPane;
    private JFrame parentFrame;  // Reference to UserManagementOptions

    public ViewAllUsers(JFrame parentFrame) {
        this.parentFrame = parentFrame;  // Store reference to parent frame

        setTitle("All Users");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // Title label
        JLabel titleLabel = new JLabel("ALL USERS", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        getContentPane().add(titleLabel, BorderLayout.NORTH);

        // Panel to hold user list
        usersPanel = new JPanel();
        usersPanel.setLayout(new BoxLayout(usersPanel, BoxLayout.Y_AXIS));
        usersPanel.setBackground(Color.WHITE);

        // Scroll pane for users panel
        scrollPane = new JScrollPane(usersPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Load and display users
        loadAndDisplayUsers();

        // Back button to return to UserManagementOptions
        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(0, 64, 128));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        backButton.addActionListener(e -> {
            setVisible(false);           // Hide this window
            parentFrame.setVisible(true); // Show parent frame
        });
        getContentPane().add(backButton, BorderLayout.SOUTH);
    }

    private void loadAndDisplayUsers() {
        // Fetch users from database
        List<String> users = fetchUsersFromDatabase();

        // Display each user
        for (String username : users) {
            JPanel userPanel = new JPanel();
            userPanel.setLayout(new BorderLayout());
            userPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            userPanel.setPreferredSize(new Dimension(400, 40));

            JLabel usernameLabel = new JLabel(username);
            usernameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            userPanel.add(usernameLabel, BorderLayout.CENTER);

            usersPanel.add(userPanel);
        }

        // Refresh the panel to show new components
        usersPanel.revalidate();
        usersPanel.repaint();
    }

    private List<String> fetchUsersFromDatabase() {
        List<String> users = new ArrayList<>();

        // Example database connection details (customize for your database)
        String url = "jdbc:mysql://127.0.0.1:3306/hotel";
        String user = "root";
        String password = "11211810jr";

        String query = "SELECT username FROM users";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
        		ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                users.add(username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching users: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }

        return users;
    }
}
