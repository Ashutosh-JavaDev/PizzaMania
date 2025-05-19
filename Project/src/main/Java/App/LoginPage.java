package main.Java.App;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.awt.Image;

public class LoginPage extends JFrame implements ActionListener {
    JButton Login, siggnup,Clear;
    JTextField mailfield;
    JPasswordField passbox;

    public LoginPage() {
        setTitle("Login Page");
        try {
            File file = new File(
                    "/home/ashutosh/Desktop/PizzaMania/PizzaMania/Project/src/main/Java/App/Images/0238e1d8-09ae-4bfd-a506-edd260a59d1c-removebg-preview.png");
            if (!file.exists()) {
                System.out.println("Image file not found!");
            }
            ImageIcon i1 = new ImageIcon(file.getAbsolutePath());

            // ImageIcon i1 = new ImageIcon(getClass().getResource("/images/pizza.jpg"));
            Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel label = new JLabel(i3);
            label.setBounds(50, 10, 100, 100);
            add(label);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        JLabel title = new JLabel("Pizza Mania");
        Font tit = new Font("Arial", Font.BOLD, 20);
        title.setFont(tit);
        title.setBounds(150, 70, 200, 20);
        add(title);
        JLabel head = new JLabel("Welcome to the Pizza Mania....");
        Font headfont = new Font("Arial", Font.ITALIC, 16);
        head.setFont(headfont);
        head.setBounds(130, 100, 220, 20);
        add(head);
        // // Email
        JLabel mail = new JLabel("Email:");
        Font font = new Font("Arial", Font.BOLD, 20);
        mail.setFont(font);
        mail.setBounds(80, 150, 70, 20);
        add(mail);
        // Password
        JLabel password = new JLabel("Password:");
        Font pass = new Font("Arial", Font.BOLD, 20);
        password.setFont(pass);
        password.setBounds(80, 200, 120, 20);
        add(password);
        // Mail Box
        mailfield = new JTextField();
        mailfield.setBounds(110, 180, 150, 20);
        add(mailfield);
        // Password Box
        passbox = new JPasswordField();
        passbox.setBounds(110, 230, 150, 20);
        add(passbox);
        // Button
        Clear = new JButton("Clear");
        Clear.setBounds(300, 270, 80, 40);
        Font ClearFont = new Font("Arial", Font.BOLD, 14);
        Clear.setFont(ClearFont);
        add(Clear);
        Clear.addActionListener(this);
        // DSignup
        siggnup = new JButton("Signup");
        siggnup.setBounds(100, 270, 100, 40);
        Font signupfont = new Font("Arial", Font.BOLD, 14);
        siggnup.setFont(signupfont);
        add(siggnup);
        siggnup.addActionListener(this);
        // Clear
        Login = new JButton("Login");
        Login.setBounds(10, 270, 80, 40);
        Font LoginFont = new Font("Arial", Font.BOLD, 14);
        Login.setFont(LoginFont);
        add(Login);
        Clear.addActionListener(this);
        // Frame Creation
        setLayout(null);
        setSize(500, 400);
        setLocation(300, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==Clear){
            mailfield.setText("");
            passbox.setText("");
        }
        if (ae.getSource() == Login) {
            String emmailID = mailfield.getText();
            String password = passbox.getText();
            String query = "select*from LoginPage where Email='" + emmailID + "' and Password='" + password + "'";
            try{
                DatabaseConnectivity conn=new DatabaseConnectivity();
                ResultSet res=conn.statem.executeQuery(query);
                if(res.next()){
                    setVisible(false);
                    new main();
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Email ID or password Not Matched");
                    ae.setSource(Clear);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
