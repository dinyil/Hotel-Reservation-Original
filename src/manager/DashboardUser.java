package manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;

public class DashboardUser extends JPanel {

    private static final long serialVersionUID = 1L;

    public DashboardUser(String email) {
    	setBackground(new Color(255, 255, 255));
        // Set the size and layout of the panel
        setBounds(100, 100, 1243, 875);
        setLayout(null);
        
        // Top Logo Panel
        ImageIcon logoIcon = new ImageIcon("/resources/ImageIcon/navbar.png");
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(0, 30, 300, 76); // Adjusts to the icon's original dimensions
        add(logoLabel); // Add the logoLabel directly to the content pane
        
        // Left Navigation Panel
        JPanel navPanel = new JPanel();
        navPanel.setBounds(0, 109, 230, 766);
        navPanel.setBackground(new Color(255, 204, 102));
        add(navPanel);
        navPanel.setLayout(null);
        
        JButton btnAsd = new JButton("CHECKIN");
        btnAsd.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnAsd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnAsd.setBounds(10, 51, 180, 80);
        navPanel.add(btnAsd);
        
        JButton btnAsd_1 = new JButton("CHECK OUT");
        btnAsd_1.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnAsd_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnAsd_1.setBounds(10, 155, 180, 80);
        navPanel.add(btnAsd_1);
        
        JButton btnAsd_2 = new JButton("ROOMS");
        btnAsd_2.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnAsd_2.setBounds(10, 257, 180, 80);
        navPanel.add(btnAsd_2);
        
        JButton btnAsd_3 = new JButton("TERMS & CONDITIONS");
        btnAsd_3.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnAsd_3.setBounds(10, 362, 180, 80);
        navPanel.add(btnAsd_3);
        
        JButton btnAsd_4 = new JButton("GUEST");
        btnAsd_4.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnAsd_4.setBounds(10, 467, 180, 80);
        navPanel.add(btnAsd_4);
        
        JButton btnAsd_5 = new JButton("LOGOUT");
        btnAsd_5.setBackground(new Color(0, 0, 128));
        btnAsd_5.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnAsd_5.setBounds(10, 693, 180, 48);
        navPanel.add(btnAsd_5);
        
        JLabel label = new JLabel("New label");
        label.setBackground(new Color(0, 128, 192));
        label.setBounds(338, 565, 328, -58);
        add(label);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 128, 192));
        panel.setBounds(198, 109, 1045, 766);
        add(panel);
        panel.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 222, 173));
        panel_1.setBounds(73, 32, 920, 223);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(0, 0, 382, 223);
        panel_1.add(lblNewLabel);
        lblNewLabel.setIcon(new ImageIcon("/resources/ImageIcon/image 14.png"));
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 165, 0));
        panel_2.setBounds(749, 0, 171, 80);
        panel_1.add(panel_2);
        panel_2.setLayout(null);
        
        JTextPane txtpnnight = new JTextPane();
        txtpnnight.setText(" $400 /Night");
        txtpnnight.setFont(new Font("Tahoma", Font.BOLD, 16));
        txtpnnight.setBackground(new Color(255, 165, 0));
        txtpnnight.setBounds(29, 25, 110, 32);
        panel_2.add(txtpnnight);
        
        JTextPane txtpnGrandOceanviewSuite_2 = new JTextPane();
        txtpnGrandOceanviewSuite_2.setText("Grand Oceanview Suite");
        txtpnGrandOceanviewSuite_2.setFont(new Font("Tahoma", Font.BOLD, 22));
        txtpnGrandOceanviewSuite_2.setBackground(new Color(255, 222, 173));
        txtpnGrandOceanviewSuite_2.setBounds(396, 47, 275, 33);
        panel_1.add(txtpnGrandOceanviewSuite_2);
        
        JTextPane txtpnLoremIpsumDolor_2 = new JTextPane();
        txtpnLoremIpsumDolor_2.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        txtpnLoremIpsumDolor_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        txtpnLoremIpsumDolor_2.setBackground(new Color(255, 222, 173));
        txtpnLoremIpsumDolor_2.setBounds(398, 90, 494, 122);
        panel_1.add(txtpnLoremIpsumDolor_2);
        
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBackground(new Color(255, 228, 181));
        panel_1_1.setBounds(73, 266, 920, 223);
        panel.add(panel_1_1);
        panel_1_1.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon("/resources/ImageIcon/image 15.png"));
        lblNewLabel_1.setBounds(0, 0, 382, 223);
        panel_1_1.add(lblNewLabel_1);
        
        JPanel panel_2_1 = new JPanel();
        panel_2_1.setBackground(new Color(255, 165, 0));
        panel_2_1.setBounds(749, 0, 171, 80);
        panel_1_1.add(panel_2_1);
        panel_2_1.setLayout(null);
        
        JTextPane txtpnnight_1 = new JTextPane();
        txtpnnight_1.setText(" $400 /Night");
        txtpnnight_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        txtpnnight_1.setBackground(new Color(255, 165, 0));
        txtpnnight_1.setBounds(32, 25, 110, 32);
        panel_2_1.add(txtpnnight_1);
        
        JTextPane txtpnGrandOceanviewSuite_1 = new JTextPane();
        txtpnGrandOceanviewSuite_1.setText("Grand Oceanview Suite");
        txtpnGrandOceanviewSuite_1.setFont(new Font("Tahoma", Font.BOLD, 22));
        txtpnGrandOceanviewSuite_1.setBackground(new Color(255, 222, 173));
        txtpnGrandOceanviewSuite_1.setBounds(392, 47, 275, 33);
        panel_1_1.add(txtpnGrandOceanviewSuite_1);
        
        JTextPane txtpnLoremIpsumDolor_1 = new JTextPane();
        txtpnLoremIpsumDolor_1.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        txtpnLoremIpsumDolor_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        txtpnLoremIpsumDolor_1.setBackground(new Color(255, 222, 173));
        txtpnLoremIpsumDolor_1.setBounds(394, 90, 494, 122);
        panel_1_1.add(txtpnLoremIpsumDolor_1);
        
        JPanel panel_1_2 = new JPanel();
        panel_1_2.setBackground(new Color(255, 228, 181));
        panel_1_2.setBounds(73, 500, 920, 223);
        panel.add(panel_1_2);
        panel_1_2.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setIcon(new ImageIcon("/resources/ImageIcon/image 16.png"));
        lblNewLabel_2.setBounds(0, 0, 382, 223);
        panel_1_2.add(lblNewLabel_2);
        
        JPanel panel_2_2 = new JPanel();
        panel_2_2.setBackground(new Color(255, 165, 0));
        panel_2_2.setBounds(749, 0, 171, 80);
        panel_1_2.add(panel_2_2);
        panel_2_2.setLayout(null);
        
        JTextPane txtpnnight_1_1 = new JTextPane();
        txtpnnight_1_1.setText(" $400 /Night");
        txtpnnight_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        txtpnnight_1_1.setBackground(new Color(255, 165, 0));
        txtpnnight_1_1.setBounds(35, 25, 110, 32);
        panel_2_2.add(txtpnnight_1_1);
        
        JTextPane txtpnGrandOceanviewSuite = new JTextPane();
        txtpnGrandOceanviewSuite.setFont(new Font("Tahoma", Font.BOLD, 22));
        txtpnGrandOceanviewSuite.setText("Grand Oceanview Suite");
        txtpnGrandOceanviewSuite.setBackground(new Color(255, 222, 173));
        txtpnGrandOceanviewSuite.setBounds(392, 47, 275, 33);
        panel_1_2.add(txtpnGrandOceanviewSuite);
        
        JTextPane txtpnLoremIpsumDolor = new JTextPane();
        txtpnLoremIpsumDolor.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        txtpnLoremIpsumDolor.setFont(new Font("Tahoma", Font.BOLD, 12));
        txtpnLoremIpsumDolor.setBackground(new Color(255, 222, 173));
        txtpnLoremIpsumDolor.setBounds(394, 90, 494, 122);
        panel_1_2.add(txtpnLoremIpsumDolor);
        
        JTextPane txtpnHelloUsername = new JTextPane();
        txtpnHelloUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
        txtpnHelloUsername.setBackground(new Color(255, 255, 255));
        txtpnHelloUsername.setText("              Hello , Username!");
        txtpnHelloUsername.setBounds(993, 46, 299, 44);
        add(txtpnHelloUsername);
        

        // Navigation Buttons
        String[] navItems = {"CHECK IN", "CHECK OUT", "ROOMS", "TERMS & CONDITIONS", "GUESTS", "LOG OUT"};
        for (String item : navItems) {
            JButton button = new JButton(item);
            button.setBackground(new Color(0, 51, 102));
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Arial", Font.BOLD, 14));
            navPanel.add(button);
        }

    }
    private Image loadImage(String path) {
        URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL).getImage();
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
