package main.Java.App;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseConnectivity {
    Connection conn;
    Statement statem;

    public DatabaseConnectivity() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///BankManagementSystem", "root", "@Radhakrishna297");
            statem = conn.createStatement();
        }

        catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Class Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }
}
