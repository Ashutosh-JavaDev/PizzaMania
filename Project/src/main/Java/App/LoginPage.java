package main.Java.App;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class LoginPage extends JFrame implements ActionListener {
    public LoginPage() {
        setTitle("Login Page");
        JLabel li = new JLabel("Email:");
        Font font = new Font("Arial", Font.BOLD, 20);
        li.setFont(font);
        li.setBounds(20, 20,70, 20);
        add(li);
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
