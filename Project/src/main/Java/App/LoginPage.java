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
        try{
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("/home/ashutosh/Desktop/PizzaMania/PizzaMania/Project/src/main/Java/App/LoginPage.java"));
            Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel label = new JLabel(i3);
            label.setBounds(50, 10, 100, 100);
            add(label);
        JLabel title=new JLabel("Pizza Mania");
        title.setBounds(170,70,100,30);
        add(title);
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }
        // // Email
        JLabel mail = new JLabel("Email:");
        Font font = new Font("Arial", Font.BOLD, 20);
        mail.setFont(font);
        mail.setBounds(80, 220,70, 20);
        add(mail);
        // Password
        JLabel password = new JLabel("Password:");
        Font pass = new Font("Arial", Font.BOLD, 20);
        password.setFont(pass);
        password.setBounds(80, 270,120, 20);
        add(password);
        // Mail Box
        JTextField mailfield=new JTextField();
        mailfield.setBounds(110,250,150,20);
        add(mailfield);
        // Password  Box
        JPasswordField passbox=new JPasswordField();
        passbox.setBounds(110,300,150,20);
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
