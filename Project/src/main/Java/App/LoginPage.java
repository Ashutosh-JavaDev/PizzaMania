package main.Java.App;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.awt.Image;

public class LoginPage extends JFrame implements ActionListener {
    public LoginPage() {
        setTitle("Login Page");
        try {
            File file = new File("/home/ashutosh/Desktop/PizzaMania/PizzaMania/Project/src/main/Java/App/Images/0238e1d8-09ae-4bfd-a506-edd260a59d1c-removebg-preview.png");
            if (!file.exists()) {
                System.out.println("Image file not found!");
            }
            ImageIcon i1 = new ImageIcon(file.getAbsolutePath());

            // ImageIcon i1 = new ImageIcon(getClass().getResource("/images/pizza.jpg"));
            Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel label = new JLabel(i3);
            label.setBounds(50, 10, 100, 100);
            add(label);
           
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        JLabel title = new JLabel("Pizza Mania");
        Font tit=new Font("Arial",Font.BOLD,20);
        title.setFont(tit);
        title.setBounds(150, 70, 200, 20);
        add(title);
        JLabel head = new JLabel("Welcome to the Pizza Mania....");
        Font headfont=new Font("Arial",Font.ITALIC,16);
        head.setFont(headfont);
        head.setBounds(130,100, 220, 20);
        add(head);
        // // Email
        JLabel mail = new JLabel("Email:");
        Font font = new Font("Arial", Font.BOLD, 20);
        mail.setFont(font);
        mail.setBounds(80,150, 70, 20);
        add(mail);
        // Password
        JLabel password = new JLabel("Password:");
        Font pass = new Font("Arial", Font.BOLD, 20);
        password.setFont(pass);
        password.setBounds(80, 200, 120, 20);
        add(password);
        // Mail Box
        JTextField mailfield = new JTextField();
        mailfield.setBounds(110,180, 150, 20);
        add(mailfield);
        // Password Box
        JPasswordField passbox = new JPasswordField();
        passbox.setBounds(110, 230, 150, 20);
        add(passbox);
        // Button
        JButton button=new JButton("Login");
        button.setBounds(300,270,80,40);
        Font buttonFont=new Font("Arial",Font.BOLD,14);
        button.setFont(buttonFont);
        add(button);
        // DSignup
        JButton siggnup=new JButton("Signup");
        siggnup.setBounds(100,270,100,40);
        Font signupfont=new Font("Arial",Font.BOLD,14);
        siggnup.setFont(signupfont);
        add(siggnup);
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
