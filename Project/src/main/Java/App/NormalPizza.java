package main.Java.App;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.PreparedStatement;
import java.awt.Image;
import java.awt.BorderLayout;
public class NormalPizza extends JFrame  implements ActionListener{
    public NormalPizza(){
        setLayout(null);
        setSize(700, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){

    }
    public static void main(String[] args) {
        new NormalPizza();
    }
}
