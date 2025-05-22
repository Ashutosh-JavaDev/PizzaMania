package main.Java.App;

import javax.management.RuntimeErrorException;
import javax.swing.*;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.awt.Image;
import java.awt.BorderLayout;

public class Pizzamenu extends JFrame implements ActionListener {
    JLabel Pizzaname;
    String[] list = { "Veg Pizza", "Non-Veg Pizza", "Delux Veg  Pizza", "Non-Veg Delux" };
    JComboBox<String> type = new JComboBox<>(list);

    public Pizzamenu() {

        setTitle("Pizza Mania");
        // title
        JLabel label = new JLabel("Welcome to Pizza Mania!");
        Font labelFont = new Font("Serif", Font.PLAIN, 24);
        label.setFont(labelFont);
        label.setBounds(150, 10, 300, 30);
        add(label);
        //
        Pizzaname = new JLabel("Pizza Name");
        Font pizzaFont = new Font("Arial", Font.BOLD, 18);
        Pizzaname.setFont(pizzaFont);
        Pizzaname.setBounds(30, 50, 150, 30);
        add(Pizzaname);
        // type
        type.setBounds(150, 50, 150, 30);
        add(type);
        setLayout(null);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Pizzamenu::new);
    }
}
