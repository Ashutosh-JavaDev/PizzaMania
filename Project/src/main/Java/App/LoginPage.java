package main.Java.App;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.Image;
public class LoginPage extends JFrame implements ActionListener {
    public LoginPage() {
        setTitle("Login Page");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/pizza-svgrepo-com.svg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, DO_NOTHING_ON_CLOSE);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        add(label);
        // Email
        JLabel mail = new JLabel("Email:");
        Font font = new Font("Arial", Font.BOLD, 20);
        mail.setFont(font);
        mail.setBounds(20, 20,70, 20);
        add(mail);
        // Password
        JLabel password = new JLabel("Password:");
        Font pass = new Font("Arial", Font.BOLD, 20);
        password.setFont(pass);
        password.setBounds(20, 60,120, 20);
        add(password);
        // Mail Box
        JTextField mailfield=new JTextField();
        mailfield.setBounds(110,20,150,20);
        add(mailfield);
        // Password  Box
        JPasswordField passbox=new JPasswordField();
        passbox.setBounds(150,60,150,20);
        add(passbox);
        // Frame Creation
        setLayout(null);
        setSize(500, 400);
        setLocation(300, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {

    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
