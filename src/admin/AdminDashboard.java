package admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class AdminDashboard extends JFrame {

    private String loggedInUser;
    private boolean isMainAdmin; // Added field for checking if the user is a main admin

    // Updated constructor to match loginUI.java
    public AdminDashboard(String userEmail) {
        this.loggedInUser = userEmail;
        this.isMainAdmin = isMainAdmin;
        initialize();
    }

    private void initialize() {
        setTitle("Admin Dashboard");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 1243, 843);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Left panel (Navigation bar)
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(3, 91, 150));
        leftPanel.setBounds(0, 74, 1227, 737);
        leftPanel.setLayout(null);
        contentPane.add(leftPanel);

        // Logo without resizing
        ImageIcon logoIcon = new ImageIcon("C:/Users/JC Mendez/Downloads/AuroraCoveHotel/auroraCoveHotel/ImageIcon/navbar.png");
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(0, 0, 300, 76);
        contentPane.add(logoLabel);

        // Logout button
        JButton logoutButton = new JButton("LOG OUT");
        logoutButton.setBackground(new Color(192, 192, 192));
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logout action here
            }
        });
        logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        logoutButton.setBounds(34, 179, 180, 41);
        leftPanel.add(logoutButton);

        // Right panel content (main panel)
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(new Color(255, 255, 255));
        rightPanel.setBounds(244, 11, 956, 704);
        leftPanel.add(rightPanel);

        // Button 1 with image
        JButton btnBooked = new JButton("");
        btnBooked.setBackground(new Color(3, 91, 150));
        ImageIcon button1Icon = new ImageIcon("C:/Users/JC Mendez/Downloads/AuroraCoveHotel/auroraCoveHotel/ImageIcon/Booked.png");
        btnBooked.setIcon(new ImageIcon(button1Icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        btnBooked.setBounds(30, 26, 265, 664);
        btnBooked.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Button 1 action
            }
        });
        rightPanel.add(btnBooked);

        // Button 2 with image
        JButton btnGuest = new JButton("");
        btnGuest.setBackground(new Color(3, 91, 150));
        ImageIcon button2Icon = new ImageIcon("C:/Users/JC Mendez/Downloads/AuroraCoveHotel/auroraCoveHotel/ImageIcon/Guest.png");
        btnGuest.setIcon(new ImageIcon(button2Icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        btnGuest.setBounds(332, 26, 265, 664);
        rightPanel.add(btnGuest);

        // Button 3 with image
        JButton btnHotel = new JButton("");
        btnHotel.setBackground(new Color(3, 91, 150));
        ImageIcon button3Icon = new ImageIcon("C:/Users/JC Mendez/Downloads/AuroraCoveHotel/auroraCoveHotel/ImageIcon/hotel.png");
        btnHotel.setIcon(new ImageIcon(button3Icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        btnHotel.setBounds(643, 26, 265, 320);
        btnHotel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Button 3 action
            }
        });
        rightPanel.add(btnHotel);

        // Button 4 with image
        JButton btnSettings = new JButton("");
        btnSettings.setBackground(new Color(3, 91, 150));
        ImageIcon button4Icon = new ImageIcon("C:/Users/JC Mendez/Downloads/AuroraCoveHotel/auroraCoveHotel/ImageIcon/settings.png");
        btnSettings.setIcon(new ImageIcon(button4Icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        btnSettings.setBounds(643, 370, 265, 320);
        rightPanel.add(btnSettings);

        // User label
        JLabel userLabel = new JLabel("Username: " + loggedInUser);
        userLabel.setBounds(34, 60, 180, 90);
        userLabel.setBackground(new Color(192, 192, 192));
        userLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
        userLabel.setForeground(Color.WHITE);
        leftPanel.add(userLabel);
    }

    public static void main(String[] args) {
        AdminDashboard frame = new AdminDashboard("SuperNila"); // Default test admin
        frame.setVisible(true);
    }
}
