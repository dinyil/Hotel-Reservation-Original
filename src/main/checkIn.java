package main;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;

public class checkIn {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Aurora Cove - Hotel Check-In");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(959, 600);
        frame.getContentPane().setLayout(new BorderLayout());

        // Main Panel
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Guest Details Panel
        JPanel guestDetailsPanel = new JPanel();
        guestDetailsPanel.setBorder(new TitledBorder("Guest Details"));
        guestDetailsPanel.setLayout(null);
        
        JLabel label = new JLabel("First Name:");
        label.setBounds(6, 16, 215, 44);
        guestDetailsPanel.add(label);
        JTextField firstNameField = new JTextField();
        firstNameField.setBounds(226, 16, 215, 44);
        guestDetailsPanel.add(firstNameField);

        JLabel label_1 = new JLabel("Last Name:");
        label_1.setBounds(6, 65, 215, 44);
        guestDetailsPanel.add(label_1);
        JTextField lastNameField = new JTextField();
        lastNameField.setBounds(226, 65, 215, 44);
        guestDetailsPanel.add(lastNameField);

        JLabel label_2 = new JLabel("Phone No.:");
        label_2.setBounds(6, 114, 215, 44);
        guestDetailsPanel.add(label_2);
        JTextField phoneField = new JTextField();
        phoneField.setBounds(226, 114, 215, 44);
        guestDetailsPanel.add(phoneField);

        JLabel label_3 = new JLabel("Email Address:");
        label_3.setBounds(6, 163, 215, 44);
        guestDetailsPanel.add(label_3);
        JTextField emailField = new JTextField();
        emailField.setBounds(226, 163, 215, 44);
        guestDetailsPanel.add(emailField);

        JLabel label_4 = new JLabel("Address:");
        label_4.setBounds(6, 212, 215, 44);
        guestDetailsPanel.add(label_4);
        JTextField addressField = new JTextField();
        addressField.setBounds(226, 212, 215, 44);
        guestDetailsPanel.add(addressField);

        JLabel label_5 = new JLabel("City:");
        label_5.setBounds(6, 261, 215, 44);
        guestDetailsPanel.add(label_5);
        JTextField cityField = new JTextField();
        cityField.setBounds(226, 261, 215, 44);
        guestDetailsPanel.add(cityField);

        JLabel label_6 = new JLabel("Nationality:");
        label_6.setBounds(6, 310, 215, 44);
        guestDetailsPanel.add(label_6);
        JTextField nationalityField = new JTextField();
        nationalityField.setBounds(226, 310, 215, 44);
        guestDetailsPanel.add(nationalityField);

        JLabel label_7 = new JLabel("ID No.:");
        label_7.setBounds(6, 359, 215, 44);
        guestDetailsPanel.add(label_7);
        JTextField idField = new JTextField();
        idField.setBounds(226, 359, 215, 44);
        guestDetailsPanel.add(idField);

        JLabel label_8 = new JLabel("ID Type:");
        label_8.setBounds(6, 408, 215, 44);
        guestDetailsPanel.add(label_8);
        JComboBox<String> idTypeComboBox = new JComboBox<>(new String[] { "Passport", "Driver's License", "Other" });
        idTypeComboBox.setBounds(226, 408, 215, 44);
        guestDetailsPanel.add(idTypeComboBox);

        mainPanel.add(guestDetailsPanel);

        // Room and Payment Panel
        JPanel roomAndPaymentPanel = new JPanel();
        roomAndPaymentPanel.setLayout(new BorderLayout());

        // Hotel Rooms Section
        JPanel hotelRoomsPanel = new JPanel();
        hotelRoomsPanel.setBorder(new TitledBorder("Hotel Rooms"));

        JCheckBox seashellSuite = new JCheckBox("Seashell Suite - ₱2,499/night");
        seashellSuite.setBounds(6, 16, 215, 23);
        JCheckBox familyCoveSuite = new JCheckBox("Family Cove Suite - ₱6,499/night");
        familyCoveSuite.setBounds(226, 16, 215, 23);
        JCheckBox grandOceanviewSuite = new JCheckBox("Grand Oceanview Suite - ₱10,499/night");
        grandOceanviewSuite.setBounds(6, 44, 215, 23);
        hotelRoomsPanel.setLayout(null);

        hotelRoomsPanel.add(seashellSuite);
        hotelRoomsPanel.add(familyCoveSuite);
        hotelRoomsPanel.add(grandOceanviewSuite);

        JLabel label_10 = new JLabel("Check-in Date:");
        label_10.setBounds(226, 44, 215, 23);
        hotelRoomsPanel.add(label_10);
        JTextField checkInDateField = new JTextField("MM/DD/YY");
        checkInDateField.setBounds(6, 72, 215, 23);
        hotelRoomsPanel.add(checkInDateField);

        JLabel label_11 = new JLabel("Check-out Date:");
        label_11.setBounds(226, 72, 215, 23);
        hotelRoomsPanel.add(label_11);
        JTextField checkOutDateField = new JTextField("MM/DD/YY");
        checkOutDateField.setBounds(6, 100, 215, 23);
        hotelRoomsPanel.add(checkOutDateField);

        roomAndPaymentPanel.add(hotelRoomsPanel, BorderLayout.NORTH);

        // Payment Section
        JPanel paymentPanel = new JPanel();
        paymentPanel.setBorder(new TitledBorder("Payment"));

        JRadioButton cashPayment = new JRadioButton("Cash");
        cashPayment.setBounds(6, 17, 415, 71);
        JRadioButton cardPayment = new JRadioButton("Credit Card");
        cardPayment.setBounds(6, 93, 415, 71);
        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(cashPayment);
        paymentGroup.add(cardPayment);

        JPanel cardDetailsPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        cardDetailsPanel.setBounds(6, 169, 435, 71);
        cardDetailsPanel.add(new JLabel("Credit Card No."));
        JTextField cardNumberField = new JTextField();
        cardDetailsPanel.add(cardNumberField);
        cardDetailsPanel.add(new JLabel("CVC"));
        JTextField cvcField = new JTextField();
        cardDetailsPanel.add(cvcField);
        cardDetailsPanel.setVisible(false);

        cardPayment.addActionListener(e -> cardDetailsPanel.setVisible(true));
        cashPayment.addActionListener(e -> cardDetailsPanel.setVisible(false));
        paymentPanel.setLayout(null);

        paymentPanel.add(cashPayment);
        paymentPanel.add(cardPayment);
        paymentPanel.add(cardDetailsPanel);
        JLabel label_9 = new JLabel("TOTAL: ₱2,499");
        label_9.setBounds(6, 245, 435, 71);
        paymentPanel.add(label_9);

        roomAndPaymentPanel.add(paymentPanel, BorderLayout.CENTER);

        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        
        mainPanel.add(roomAndPaymentPanel);
        frame.setVisible(true);
    }
}
