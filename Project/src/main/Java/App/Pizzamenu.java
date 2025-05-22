package main.Java.App;

import javax.swing.*;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Pizzamenu extends JFrame implements ActionListener {
    JLabel Pizzaname, option, types;
    String[] list = { "Veg Pizza", "Non-Veg Pizza", "Delux Veg  Pizza", "Non-Veg Delux" };
    JComboBox<String> type = new JComboBox<>(list);
    JCheckBox ExtraCheese, ExtraToppings, takeAway;
    JButton Order;
    public Pizzamenu() {

        setTitle("Pizza Mania");
        // title
        JLabel label = new JLabel("Welcome to Pizza Mania!");
        Font labelFont = new Font("Serif", Font.PLAIN, 28);
        label.setFont(labelFont);
        label.setBounds((1000 - 300) / 2, 10, 400, 30);
        add(label);
        //

        option = new JLabel("Choose Your Desire Pizza");
        Font optionFont = new Font("Arial", Font.BOLD, 20);
        option.setFont(optionFont);
        option.setBounds(380, 50, 600, 30);
        add(option);
        // Adding Image
       
        try {
            File file = new File(
                    "/home/ashutosh/Desktop/PizzaMania/PizzaMania/Project/src/main/Java/App/Images/0238e1d8-09ae-4bfd-a506-edd260a59d1c-removebg-preview.png");
            if (!file.exists()) {
                System.out.println("File Not Found");
            }
            ImageIcon i1 = new ImageIcon(file.getAbsolutePath());
            Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(500,80,450, 300);
            add(image, BorderLayout.CENTER);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        Pizzaname = new JLabel("Pizza Name");
        Font pizzaFont = new Font("Arial", Font.BOLD, 16);
        Pizzaname.setFont(pizzaFont);
        Pizzaname.setBounds(30, 100, 140, 30);
        add(Pizzaname);
        // type
        type.setBounds(150, 100, 150, 30);
        add(type);
        // Types
        types = new JLabel("Add Extra Resources");
        types.setBounds(30, 150, 250, 30);
        Font typesFont = new Font("Arial", Font.BOLD, 16);
        types.setFont(typesFont);
        add(types);
        // Extra Toppings
        ExtraToppings = new JCheckBox("Rs.150-Extra Toppings");
        ExtraToppings.setBounds(270, 150, 300, 30);
        add(ExtraToppings);
        // Extra Cheese
        ExtraCheese = new JCheckBox("Rs.100-Extra Cheese");
        ExtraCheese.setBounds(270, 190, 300, 30);
        add(ExtraCheese);
        // Take Away
        takeAway = new JCheckBox("Rs.20-Take Away");
        takeAway.setBounds(270, 230, 300, 30);
        add(takeAway);
        //
        Order=new JButton("Order Now");
        Order.setBounds(30,800,150,30);
        Order.setBackground(Color.red);
        Order.setForeground(Color.white);
        add(Order);
        setLayout(null);
        setSize(1000,400);
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
