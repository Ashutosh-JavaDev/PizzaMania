package main.Java.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import main.Java.App.theme.PizzaManiaTheme;
import main.Java.App.components.RoundedPanel;
import main.Java.App.components.ImagePanel;

public class Registration extends JFrame implements ActionListener {
    private RoundedPanel mainPanel, formPanel;
    private JLabel titleLabel, subtitleLabel;
    private JLabel fnameLabel, lnameLabel, emailLabel, phoneLabel, passwordLabel, confirmPasswordLabel;
    private JTextField fnameField, lnameField, emailField, phoneField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton submitButton, loginButton;
    private ImagePanel logoPanel;

    public boolean checkPassword(String password) {
        if ((password.length() < 8) || (password.length() > 16)) {
            JOptionPane.showMessageDialog(
                this, 
                "Password must be between 8 and 16 characters.",
                "Password Error", 
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else hasSpecial = true;
        }

        if (!hasLower || !hasUpper || !hasDigit || !hasSpecial) {
            JOptionPane.showMessageDialog(
                this, 
                "Password must contain uppercase, lowercase, digit, and special character.",
                "Password Error", 
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        return true;
    }

    public Registration() {
        setTitle("Pizza Mania - Registration");
        PizzaManiaTheme.setupFrame(this);
        setLayout(new BorderLayout(20, 20));
        
        // Main container panel
        mainPanel = new RoundedPanel(new BorderLayout(20, 20));
        mainPanel.setBackground(PizzaManiaTheme.PANEL_BACKGROUND);
        
        // Header section with logo and title
        JPanel headerPanel = new JPanel(new BorderLayout(15, 5));
        headerPanel.setOpaque(false);
        
        // Logo
        try {
            String logoPath = "/home/ashutosh/Desktop/PizzaMania/PizzaMania/Project/src/main/Java/App/Images/0238e1d8-09ae-4bfd-a506-edd260a59d1c-removebg-preview.png";
            File logoFile = new File(logoPath);
            
            if (logoFile.exists()) {
                ImageIcon logoIcon = new ImageIcon(logoFile.getAbsolutePath());
                Image logoImage = logoIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                logoPanel = new ImagePanel(logoImage);
                logoPanel.setPreferredSize(new Dimension(120, 120));
                headerPanel.add(logoPanel, BorderLayout.WEST);
            } else {
                System.out.println("Logo file not found at: " + logoPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Title section
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setOpaque(false);
        
        titleLabel = new JLabel("Create Your Account");
        titleLabel.setFont(PizzaManiaTheme.HEADING_LARGE);
        titleLabel.setForeground(PizzaManiaTheme.PRIMARY_RED);
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        subtitleLabel = new JLabel("Join Pizza Mania and start ordering your favorite pizzas!");
        subtitleLabel.setFont(PizzaManiaTheme.BODY_REGULAR);
        subtitleLabel.setForeground(PizzaManiaTheme.DARK_TEXT);
        subtitleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        titlePanel.add(titleLabel);
        titlePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        titlePanel.add(subtitleLabel);
        headerPanel.add(titlePanel, BorderLayout.CENTER);
        
        // Form panel
        formPanel = new RoundedPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 12, 8, 12);
        
        // First name
        fnameLabel = new JLabel("First Name");
        PizzaManiaTheme.styleLabel(fnameLabel, false);
        fnameField = new JTextField(15);
        PizzaManiaTheme.styleTextField(fnameField);
        
        // Last name
        lnameLabel = new JLabel("Last Name");
        PizzaManiaTheme.styleLabel(lnameLabel, false);
        lnameField = new JTextField(15);
        PizzaManiaTheme.styleTextField(lnameField);
        
        // Email
        emailLabel = new JLabel("Email Address");
        PizzaManiaTheme.styleLabel(emailLabel, false);
        emailField = new JTextField(15);
        PizzaManiaTheme.styleTextField(emailField);
        
        // Phone
        phoneLabel = new JLabel("Phone Number");
        PizzaManiaTheme.styleLabel(phoneLabel, false);
        phoneField = new JTextField(15);
        PizzaManiaTheme.styleTextField(phoneField);
        
        // Password
        passwordLabel = new JLabel("Password");
        PizzaManiaTheme.styleLabel(passwordLabel, false);
        passwordField = new JPasswordField(15);
        PizzaManiaTheme.stylePasswordField(passwordField);
        
        // Confirm Password
        confirmPasswordLabel = new JLabel("Confirm Password");
        PizzaManiaTheme.styleLabel(confirmPasswordLabel, false);
        confirmPasswordField = new JPasswordField(15);
        PizzaManiaTheme.stylePasswordField(confirmPasswordField);
        
        // Add components to form panel using GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        formPanel.add(fnameLabel, gbc);
        
        gbc.gridx = 1;
        formPanel.add(lnameLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(fnameField, gbc);
        
        gbc.gridx = 1;
        formPanel.add(lnameField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(emailLabel, gbc);
        
        gbc.gridx = 1;
        formPanel.add(phoneLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(emailField, gbc);
        
        gbc.gridx = 1;
        formPanel.add(phoneField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(passwordLabel, gbc);
        
        gbc.gridx = 1;
        formPanel.add(confirmPasswordLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        formPanel.add(passwordField, gbc);
        
        gbc.gridx = 1;
        formPanel.add(confirmPasswordField, gbc);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        buttonPanel.setOpaque(false);
        
        submitButton = new JButton("Create Account");
        PizzaManiaTheme.styleButton(submitButton, true);
        submitButton.addActionListener(this);
        
        loginButton = new JButton("Already have an account? Login");
        PizzaManiaTheme.styleButton(loginButton, false);
        loginButton.addActionListener(this);
        
        buttonPanel.add(submitButton);
        buttonPanel.add(loginButton);
        
        // Add panels to main layout
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 12, 8, 12);
        formPanel.add(buttonPanel, gbc);
        
        // Add all panels to main container
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        
        // Add main panel to frame
        add(mainPanel, BorderLayout.CENTER);
        
        // Set frame properties
        setSize(700, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginButton) {
            setVisible(false);
            new LoginPage().setVisible(true);
        }
        
        if (ae.getSource() == submitButton) {
            String firstName = fnameField.getText();
            String lastName = lnameField.getText();
            String email = emailField.getText();
            String phoneNumber = phoneField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            try {
                if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phoneNumber.isEmpty()
                        || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        this, 
                        "All fields are required!",
                        "Registration Error", 
                        JOptionPane.ERROR_MESSAGE
                    );
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(
                        this, 
                        "Passwords do not match!",
                        "Registration Error", 
                        JOptionPane.ERROR_MESSAGE
                    );
                } else if (!phoneNumber.matches("\\d{10}")) {
                    JOptionPane.showMessageDialog(
                        this, 
                        "Phone number must be exactly 10 digits!",
                        "Registration Error", 
                        JOptionPane.ERROR_MESSAGE
                    );
                } else if (!password.matches(".*[^a-zA-Z0-9 ].*")) {
                    JOptionPane.showMessageDialog(
                        this, 
                        "Password must contain at least one special character!",
                        "Registration Error", 
                        JOptionPane.ERROR_MESSAGE
                    );
                } else if (!checkPassword(password)) {
                    // The checkPassword method will show appropriate error message
                } else {
                    DatabaseConnectivity conn = new DatabaseConnectivity();

                    // Step 1: Insert into Registration
                    String regQuery = "INSERT INTO Registration(fnameField, lnameField, Email, phoneNumber, Password, confirmPassword) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement regStmt = conn.conn.prepareStatement(regQuery,
                            PreparedStatement.RETURN_GENERATED_KEYS);
                    regStmt.setString(1, firstName);
                    regStmt.setString(2, lastName);
                    regStmt.setString(3, email);
                    regStmt.setString(4, phoneNumber);
                    regStmt.setString(5, password);
                    regStmt.setString(6, confirmPassword);
                    regStmt.executeUpdate();

                    // Step 2: Insert into LoginPage
                    String loginQuery = "INSERT INTO LoginPage (Email, Password) VALUES (?, ?)";
                    PreparedStatement loginStmt = conn.conn.prepareStatement(loginQuery);
                    loginStmt.setString(1, email);
                    loginStmt.setString(2, password);
                    loginStmt.executeUpdate();                  

                    JOptionPane.showMessageDialog(
                        this, 
                        "Registration successful! You can now log in.",
                        "Registration Complete", 
                        JOptionPane.INFORMATION_MESSAGE
                    );
                    
                    setVisible(false);
                    new LoginPage().setVisible(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                    this, 
                    "Database connection not established!",
                    "Registration Error", 
                    JOptionPane.ERROR_MESSAGE
                );
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new Registration());
    }
}