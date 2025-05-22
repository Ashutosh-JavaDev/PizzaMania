package main.Java.App;

import javax.management.RuntimeErrorException;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        label.setFont(loadCustomFont("Font/Dancing_Script/static/DancingScript-Regular.ttf", Font.PLAIN, 24));
        label.setHorizontalAlignment(SwingConstants.CENTER);
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

    private Font loadCustomFont(String path, int style, float size) {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(path);
            if (is == null) {
                throw new RuntimeException("Font not found at the : " + path);
            }
            Font font = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(style, size);
        } catch (Exception e) {

        }
    }

    public void actionPerformed(ActionEvent ae) {

    }

    public static void main(String[] args) {
        new Pizzamenu();
    }
}
