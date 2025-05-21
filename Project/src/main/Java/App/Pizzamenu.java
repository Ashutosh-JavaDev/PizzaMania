package main.Java.App;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.PreparedStatement;
import java.awt.Image;
import java.awt.BorderLayout;
public class Pizzamenu extends JFrame  implements ActionListener{
    JLabel Pizzaname ,vegPizza,nonvegPizza,DeluxPizza,nondeluxPizza;
    public Pizzamenu(){
        setTitle("Pizza Mania");

        setLayout(null);
        setSize(1000,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){

    }
    public static void main(String[] args) {
        new Pizzamenu();
    }
}
