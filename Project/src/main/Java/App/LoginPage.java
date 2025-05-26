package main.Java.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.ResultSet;

import main.Java.App.theme.PizzaManiaTheme;
import main.Java.App.components.RoundedPanel;
import main.Java.App.components.ImagePanel;

public class LoginPage extends JFrame implements ActionListener {
    private RoundedPanel mainPanel, loginPanel;
    private JLabel titleLabel, subtitleLabel, emailLabel, passwordLabel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton, clearButton;
    private ImagePanel logoPanel;

    public LoginPage() {
        setTitle("Pizza Mania - Login");
        PizzaManiaTheme.setupFrame(this);
        setLayout(new BorderLayout());
        
        // Main container with two columns
        mainPanel = new RoundedPanel(new GridBagLayout());
        mainPanel.setBackground(PizzaManiaTheme.PANEL_BACKGROUND);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(0, 0, 0, 0);
        
        // Left side - Logo and decorative panel
        RoundedPanel leftPanel = new RoundedPanel(new BorderLayout());
        leftPanel.setBackground(PizzaManiaTheme.PRIMARY_RED);
        leftPanel.setForeground(PizzaManiaTheme.PRIMARY_RED);
        
        // Pizza logo in the center of left panel
        try {
            String logoPath = "/home/ashutosh/Desktop/PizzaMania/PizzaMania/Project/src/main/Java/App/Images/0238e1d8-09ae-4bfd-a506-edd260a59d1c-removebg-preview.png";
            File logoFile = new File(logoPath);
            
            if (logoFile.exists()) {
                ImageIcon logoIcon = new ImageIcon(logoFile.getAbsolutePath());
                Image logoImage = logoIcon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
                logoPanel = new ImagePanel(logoImage);
                logoPanel.setPreferredSize(new Dimension(180, 180));
                
                // Center the logo in the left panel
                JPanel centeringPanel = new JPanel(new GridBagLayout());
                centeringPanel.setOpaque(false);
                centeringPanel.add(logoPanel);
                leftPanel.add(centeringPanel, BorderLayout.CENTER);
                
                // Welcome text at the bottom
                JLabel welcomeLabel = new JLabel("Welcome to Pizza Mania", SwingConstants.CENTER);
                welcomeLabel.setFont(PizzaManiaTheme.HEADING_MEDIUM);
                welcomeLabel.setForeground(Color.WHITE);
                
                JLabel taglineLabel = new JLabel("Where every slice is a slice of happiness", SwingConstants.CENTER);
                taglineLabel.setFont(PizzaManiaTheme.BODY_REGULAR);
                taglineLabel.setForeground(Color.WHITE);
                
                JPanel welcomePanel = new JPanel();
                welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
                welcomePanel.setOpaque(false);
                welcomePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
                
                welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                taglineLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                
                welcomePanel.add(welcomeLabel);
                welcomePanel.add(Box.createRigidArea(new Dimension(0, 5)));
                welcomePanel.add(taglineLabel);
                
                leftPanel.add(welcomePanel, BorderLayout.SOUTH);
            } else {
                System.out.println("Logo file not found at: " + logoPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Right side - Login form
        loginPanel = new RoundedPanel(new GridBagLayout());
        loginPanel.setBackground(Color.WHITE);
        
        GridBagConstraints loginGbc = new GridBagConstraints();
        loginGbc.gridwidth = 1;
        loginGbc.fill = GridBagConstraints.HORIZONTAL;
        loginGbc.insets = new Insets(5, 15, 5, 15);
        loginGbc.anchor = GridBagConstraints.WEST;
        
        // Login title and subtitle
        titleLabel = new JLabel("Login to Your Account");
        titleLabel.setFont(PizzaManiaTheme.HEADING_MEDIUM);
        titleLabel.setForeground(PizzaManiaTheme.PRIMARY_RED);
        
        subtitleLabel = new JLabel("Please enter your email and password");
        subtitleLabel.setFont(PizzaManiaTheme.BODY_REGULAR);
        subtitleLabel.setForeground(PizzaManiaTheme.DARK_TEXT);
        
        // Email field
        emailLabel = new JLabel("Email Address");
        PizzaManiaTheme.styleLabel(emailLabel, false);
        
        emailField = new JTextField(20);
        PizzaManiaTheme.styleTextField(emailField);
        
        // Password field
        passwordLabel = new JLabel("Password");
        PizzaManiaTheme.styleLabel(passwordLabel, false);
        
        passwordField = new JPasswordField(20);
        PizzaManiaTheme.stylePasswordField(passwordField);
        
        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        buttonPanel.setOpaque(false);
        
        loginButton = new JButton("Login");
        PizzaManiaTheme.styleButton(loginButton, true);
        loginButton.addActionListener(this);
        
        clearButton = new JButton("Clear");
        PizzaManiaTheme.styleButton(clearButton, false);
        clearButton.addActionListener(this);
        
        buttonPanel.add(loginButton);
        buttonPanel.add(clearButton);
        
        // Register button
        registerButton = new JButton("Create Account");
        PizzaManiaTheme.styleButton(registerButton, false);
        registerButton.addActionListener(this);
        
        // Add all components to login panel
        loginGbc.gridx = 0;
        loginGbc.gridy = 0;
        loginGbc.gridwidth = 2;
        loginGbc.insets = new Insets(20, 15, 5, 15);
        loginPanel.add(titleLabel, loginGbc);
        
        loginGbc.gridy = 1;
        loginGbc.insets = new Insets(0, 15, 25, 15);
        loginPanel.add(subtitleLabel, loginGbc);
        
        loginGbc.gridy = 2;
        loginGbc.gridwidth = 1;
        loginGbc.insets = new Insets(5, 15, 5, 15);
        loginPanel.add(emailLabel, loginGbc);
        
        loginGbc.gridy = 3;
        loginGbc.insets = new Insets(5, 15, 15, 15);
        loginPanel.add(emailField, loginGbc);
        
        loginGbc.gridy = 4;
        loginGbc.insets = new Insets(5, 15, 5, 15);
        loginPanel.add(passwordLabel, loginGbc);
        
        loginGbc.gridy = 5;
        loginGbc.insets = new Insets(5, 15, 25, 15);
        loginPanel.add(passwordField, loginGbc);
        
        loginGbc.gridy = 6;
        loginGbc.gridwidth = 2;
        loginPanel.add(buttonPanel, loginGbc);
        
        loginGbc.gridy = 7;
        loginGbc.insets = new Insets(15, 15, 20, 15);
        
        JPanel registerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        registerPanel.setOpaque(false);
        
        JLabel noAccountLabel = new JLabel("Don't have an account?");
        noAccountLabel.setFont(PizzaManiaTheme.BODY_SMALL);
        
        registerPanel.add(noAccountLabel);
        registerPanel.add(registerButton);
        
        loginPanel.add(registerPanel, loginGbc);
        
        // Add panels to main layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.4;
        mainPanel.add(leftPanel, gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.6;
        mainPanel.add(loginPanel, gbc);
        
        // Add main panel to frame
        add(mainPanel);
        
        // Set frame properties
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clearButton) {
            emailField.setText("");
            passwordField.setText("");
        }
        
        if (ae.getSource() == loginButton) {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            
            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter both email and password",
                    "Login Error",
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            
            String query = "SELECT * FROM LoginPage WHERE Email='" + email + "' AND Password='" + password + "'";

            try {
                DatabaseConnectivity conn = new DatabaseConnectivity();
                ResultSet res = conn.statem.executeQuery(query);
                
                if (res.next()) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Login Successful",
                        "Welcome",
                        JOptionPane.INFORMATION_MESSAGE
                    );

                    setVisible(false);
                    new Pizzamenu(email).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(
                        this,
                        "Invalid email or password",
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE
                    );
                    emailField.setText("");
                    passwordField.setText("");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                    this,
                    "Database connection error",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
                e.printStackTrace();
            }
        }
        
        if (ae.getSource() == registerButton) {
            setVisible(false);
            new Registration().setVisible(true);
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new LoginPage().setVisible(true));
    }
}