package main.Java.App;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
class connectivity{
    Statement state;
    public connectivity() throws SQLException{
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql:///PizzaMania", "root", "@Radhakrishna297");
             state=conn.createStatement();
            
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Class Not Found", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

}
public class DatabaseConnectivity {
    connectivity ob;
    public DatabaseConnectivity() throws SQLException{
        ob=new connectivity();
    }
}
