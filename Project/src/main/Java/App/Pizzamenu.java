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
    public int Vegpizza = 300;
    public int nonVegpizza = 400;
    public int DeluxVegpizza = 550;
    public int DeluxNonVegpizza = 650;
    public int deliveryCharges = 20;
    JLabel Pizzaname, option, types;
    String[] list = { "Veg Pizza", "Non-Veg Pizza", "Delux Veg  Pizza", "Delux Non-Veg Pizza" };
    JComboBox<String> type = new JComboBox<>(list);
    JCheckBox ExtraCheese, ExtraToppings, takeAway;
    JButton Order;
    JPanel panel;

    public Pizzamenu() {
        panel = new JPanel();
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
            image.setBounds(500, 80, 450, 300);
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

        type.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String selectedPizza = (String) type.getSelectedItem();
                if (selectedPizza.equals("Veg Pizza")) {
                    JOptionPane.showMessageDialog(null, "You selected Veg Pizza. Enjoy your green delight!");
                } else if (selectedPizza.equals("Non-Veg Pizza")) {
                    JOptionPane.showMessageDialog(null, "Non-Veg Pizza selected. Meaty and delicious!");
                } else if (selectedPizza.equals("Delux Veg  Pizza")) {
                    JOptionPane.showMessageDialog(null, "Delux Veg Pizza — loaded with extra veggies!");
                } else if (selectedPizza.equals("Non-Veg Delux")) {
                    JOptionPane.showMessageDialog(null, "Non-Veg Delux — top-tier indulgence!");
                }
            }
        });
        // Types
        types = new JLabel("Add Extra Resources");
        types.setBounds(30, 150, 250, 30);
        Font typesFont = new Font("Arial", Font.BOLD, 16);
        types.setFont(typesFont);
        add(types);
        // Extra Toppings
        ExtraToppings = new JCheckBox("Rs.150-Extra Toppings");
        ExtraToppings.setBounds(210, 150, 300, 30);
        ExtraToppings.setBackground(Color.yellow);
        add(ExtraToppings);
        // Extra Cheese
        ExtraCheese = new JCheckBox("Rs.100-Extra Cheese");
        ExtraCheese.setBounds(210, 190, 300, 30);
        ExtraCheese.setBackground(Color.yellow);

        add(ExtraCheese);
        // Take Away
        takeAway = new JCheckBox("Rs.20-Take Away");
        takeAway.setBounds(210, 230, 300, 30);
        takeAway.setBackground(Color.yellow);

        add(takeAway);
        //
        Order = new JButton("Order Now");
        Order.setBounds(30, 300, 150, 30);
        Font orderFont = new Font("Arial", Font.BOLD, 16);
        Order.setFont(orderFont);
        Order.setBackground(Color.red);
        Order.setForeground(Color.white);
        add(Order);
        Order.addActionListener(this);
        panel.setSize(1000, 400);
        panel.setBackground(Color.yellow);
        add(panel);
        setLayout(null);
        setSize(1000, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == Order) {
            String selectedPizza = (String) type.getSelectedItem();
            boolean cheese = ExtraCheese.isSelected();
            boolean toppings = ExtraToppings.isSelected();
            boolean TakeAway = takeAway.isSelected();
            int total = 0;
            if (selectedPizza.equals("Veg Pizza")) {
                total += 200;
            } else if (selectedPizza.equals("Non Veg Pizza")) {
                total += 300;
            } else if (selectedPizza.equals("Delux Veg Pizza")) {
                total += 300;
            } else if (selectedPizza.equals("Delux Non-Veg Pizza")) {
                total += 350;
            }
            // Add
            if(cheese){
                 total+=100;
            }
            else if(toppings){
                total+=150;
            }
            else if(TakeAway){
                total+=20;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Pizzamenu::new);
    }
}
