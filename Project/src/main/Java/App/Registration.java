package main.Java.App;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.Image;
import java.awt.BorderLayout;

public class Registration extends JFrame implements ActionListener {
    JLabel title, Fname, Lname, email, phone, password, ConfirmPassword;
    JTextField FnameField, LnameField, emailfield, phonefield;
    JPasswordField passwordField, ConfirmPasswordField;
    JButton submit;

    public Registration() {
        try {
            File file = new File(
                    "/home/ashutosh/Desktop/PizzaMania/PizzaMania/Project/src/main/Java/App/Images/0238e1d8-09ae-4bfd-a506-edd260a59d1c-removebg-preview.png");
            if (!file.exists()) {
                System.out.println("Image file not found!");
            }
            ImageIcon i1 = new ImageIcon(file.getAbsolutePath());

            // ImageIcon i1 = new ImageIcon(getClass().getResource("/images/pizza.jpg"));
            Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel label = new JLabel(i3);
            label.setBounds(270, 200, 410, 410);
            add(label, BorderLayout.CENTER);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        // 2. Title
        title = new JLabel("User Registration Form");
        title.setBounds(220, 120, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);

        // 3. First Name
        Fname = new JLabel("First Name");
        Fname.setBounds(50, 180, 100, 25);
        Fname.setFont(new Font("Arial", Font.BOLD, 15));
        add(Fname);

        FnameField = new JTextField();
        FnameField.setBounds(150, 180, 200, 25);
        add(FnameField);

        // 4. Last Name
        Lname = new JLabel("Last Name");
        Lname.setBounds(380, 180, 100, 25);
        Lname.setFont(new Font("Arial", Font.BOLD, 15));
        add(Lname);

        LnameField = new JTextField();
        LnameField.setBounds(480, 180, 200, 25);
        add(LnameField);
        setLayout(null);
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

    }

    public static void main(String[] args) {
        new Registration();
    }

}
