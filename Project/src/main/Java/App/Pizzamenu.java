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
    JLabel Pizzaname;
    JCheckBox type=new JCheckBox("'Veg Pizza','Non-Veg Pizza','Delux Veg  Pizza','Non-Veg Delux'");
    public Pizzamenu(){
        setTitle("Pizza Mania");
        Pizzaname=new JLabel("Pizza Name");
        Pizzaname.setBounds(10, 50, 150, 30);
        add(Pizzaname);
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
