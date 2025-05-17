package main.Java.App;
import javax.swing.*;
import java.sql.SQLException;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.util.Scanner;
import java.awt.Image;
public class Registration extends  JFrame implements ActionListener {
    JLabel title,Fname,Lname,email,phone,password,ConfirmmPassword;
    public Registration(){
        setTitle("Registration Form");

        setLayout(null);
        setSize(700,600);
        setLocation(600, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        
    }
    public static void main(String[] args) {
        new Registration();
    }
    
}
