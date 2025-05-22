package main.Java.App;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.PreparedStatement;
import java.awt.Image;
import java.awt.BorderLayout;

public class Registration extends JFrame implements ActionListener {
    JLabel title, Fname, Lname, email, phone, password, ConfirmPassword;
    JTextField FnameField, LnameField, emailfield, phonefield;
    JPasswordField passwordField, ConfirmPasswordField;
    JButton submit;

    public boolean checkpas(String Password) {
        if ((Password.length() < 8) || (Password.length() > 16)) {
            JOptionPane.showMessageDialog(rootPane, "Password must be between 8 and 16 characters.");
            return false;
        }

        boolean res = false;
        for (int i = 0; i < Password.length(); i++) { // include last character
            char ch = Password.charAt(i);
            if (Character.isLowerCase(ch) || Character.isUpperCase(ch) || Character.isDigit(ch)) {
                res = true;
            }
        }

        return res;
    }

    public Registration() {
        try {
            File file = new File(
                    "/home/ashutosh/Desktop/PizzaMania/PizzaMania/Project/src/main/Java/App/Images/0238e1d8-09ae-4bfd-a506-edd260a59d1c-removebg-preview.png");
            if (!file.exists()) {
                System.out.println("Image file not found!");
            }
            ImageIcon i1 = new ImageIcon(file.getAbsolutePath());

            // ImageIcon i1 = new ImageIcon(getClass().getResource("/images/pizza.jpg"));
            Image i2 = i1.getImage().getScaledInstance(230, 230, Image.SCALE_SMOOTH);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel label = new JLabel(i3);
            label.setBounds(400, 200, 240, 240);
            add(label, BorderLayout.CENTER);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        // Title
        setTitle("Registration Form");
        title = new JLabel("User Registration Form");
        title.setBounds(250, 10, 250, 25);
        Font tFont = new Font("Arial", Font.BOLD, 18);
        title.setFont(tFont);
        add(title);
        // FirstName
        Fname = new JLabel("First Name");
        Fname.setBounds(10, 60, 90, 25);
        Font fFont = new Font("Arial", Font.BOLD, 15);
        Fname.setFont(fFont);
        add(Fname);
        FnameField = new JTextField();
        FnameField.setBounds(110, 60, 150, 25);
        Font fFieldFont = new Font("Arial", Font.PLAIN, 12);
        FnameField.setFont(fFieldFont);
        add(FnameField);
        // Second Name
        Lname = new JLabel("Last Name");
        Lname.setBounds(320, 60, 90, 25);
        Font lFont = new Font("Arial", Font.BOLD, 15);
        Lname.setFont(lFont);
        add(Lname);
        LnameField = new JTextField();
        LnameField.setBounds(420, 60, 150, 25);
        Font lFieldFont = new Font("Arial", Font.PLAIN, 12);
        LnameField.setFont(lFieldFont);
        add(LnameField);
        // Email
        email = new JLabel("Email ID");
        email.setBounds(10, 110, 100, 25);
        email.setFont(new Font("Arial", Font.BOLD, 15));
        add(email);

        emailfield = new JTextField();
        emailfield.setBounds(110, 110, 150, 25);
        emailfield.setFont(new Font("Arial", Font.BOLD, 15));
        add(emailfield);
        // phone
        phone = new JLabel("Contact No.");
        phone.setBounds(320, 110, 150, 25);
        phone.setFont(new Font("Arial", Font.BOLD, 15));
        add(phone);

        phonefield = new JTextField();
        phonefield.setBounds(420, 110, 150, 25);
        phonefield.setFont(new Font("Arial", Font.BOLD, 15));
        add(phonefield);
        // Password
        password = new JLabel("Password");
        password.setBounds(10, 160, 100, 25);
        password.setFont(new Font("Arial", Font.BOLD, 15));
        add(password);
        passwordField = new JPasswordField();
        passwordField.setBounds(110, 160, 150, 25);
        passwordField.setFont(new Font("Arial", Font.BOLD, 15));
        add(passwordField);
        // checkPassword
        ConfirmPassword = new JLabel("Confirm");
        ConfirmPassword.setBounds(320, 160, 100, 25);
        ConfirmPassword.setFont(new Font("Arial", Font.BOLD, 15));
        add(ConfirmPassword);
        ConfirmPasswordField = new JPasswordField();
        ConfirmPasswordField.setBounds(420, 160, 150, 25);
        ConfirmPasswordField.setFont(new Font("Arial", Font.BOLD, 15));
        add(ConfirmPasswordField);
        // Button
        submit = new JButton("Submit");
        submit.setBounds(10, 250, 100, 25);
        submit.setFont(new Font("Arial", Font.BOLD, 15));
        add(submit);
        submit.addActionListener(this);
        setLayout(null);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String fnameField = FnameField.getText();
            String lnameField = LnameField.getText();
            String Email = emailfield.getText();
            String phoneNumber = phonefield.getText();
            String Password = passwordField.getText();
            String confirmPassword = ConfirmPasswordField.getText();

            try {

                if (fnameField.isEmpty() || lnameField.isEmpty() || Email.isEmpty() || phoneNumber.isEmpty()
                        || Password.isEmpty()
                        || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "All fields are required!");
                } else if (!Password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(rootPane, "Passwords do not match!");
                } else if (!phoneNumber.matches("\\d{10}")) {
                    JOptionPane.showMessageDialog(rootPane, "Phone number must be exactly 10 digits!");
                } else if (!Password.matches(".*[^a-zA-Z0-9 ].*")) {
                    JOptionPane.showMessageDialog(rootPane, "Password must contain at least one special character!");
                } else if (!checkpas(Password)) {
                    JOptionPane.showMessageDialog(rootPane, "Password must contain Uppercase and Lowercase and Digit");
                } else {
                    DatabaseConnectivity conn = new DatabaseConnectivity();

                    String sql = "INSERT INTO Registration (fnameField, lnameField, Email, phoneNumber, Password, confirmPassword) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = conn.conn.prepareStatement(sql);
                    pstmt.setString(1, fnameField);
                    pstmt.setString(2, lnameField);
                    pstmt.setString(3, Email);
                    pstmt.setString(4, phoneNumber);
                    pstmt.setString(5, Password);
                    pstmt.setString(6, confirmPassword);
                    pstmt.executeUpdate();
                    
                    String loginQuery = "INSERT INTO LoginPage (Email, Password) VALUES (?, ?)";
                    PreparedStatement loginStmt = conn.conn.prepareStatement(loginQuery);
                    loginStmt.setString(1, Email);
                    loginStmt.setString(2, Password);
                    loginStmt.executeUpdate();
                    
                    JOptionPane.showMessageDialog(rootPane, "Registration successful!");
                    setVisible(false);
                    new LoginPage().setVisible(true);

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Database connection not established!");

                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new Registration();
    }

}
