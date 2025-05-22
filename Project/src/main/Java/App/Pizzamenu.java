package main.Java.App;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Pizzamenu extends JFrame implements ActionListener {
    JLabel Pizzaname,option,types;
    String[] list = { "Veg Pizza", "Non-Veg Pizza", "Delux Veg  Pizza", "Non-Veg Delux" };
    JComboBox<String> type = new JComboBox<>(list);
    JCheckBox extraType=new JCheckBox("'Extra Cheese'\n'Extra Toppings'");
    public Pizzamenu() {

        setTitle("Pizza Mania");
        // title
        JLabel label = new JLabel("Welcome to Pizza Mania!");
        Font labelFont = new Font("Serif", Font.PLAIN, 28);
        label.setFont(labelFont);
        label.setBounds((1000-300)/2, 10, 400, 30);
        add(label);
        //

        option=new JLabel("Choose Your Desire Pizza");
        Font optionFont = new Font("Arial", Font.BOLD,20);
        option.setFont(optionFont);
        option.setBounds(380, 50, 600, 30);
        add(option);
        Pizzaname = new JLabel("Pizza Name");
        Font pizzaFont = new Font("Arial", Font.BOLD, 16);
        Pizzaname.setFont(pizzaFont);
        Pizzaname.setBounds(30, 100, 140, 30);
        add(Pizzaname);
        // type
        type.setBounds(150,100, 150, 30);
        add(type);
        // Types
        types=new JLabel("Add Extra Resources");
        types.setBounds(30,150,250,30);
         Font typesFont = new Font("Arial", Font.BOLD,16);
        types.setFont(typesFont);
        add(types);
        extraType.setBounds(300,100,100,30);
        add(extraType);
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
