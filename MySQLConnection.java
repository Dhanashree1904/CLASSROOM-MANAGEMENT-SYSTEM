/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {
    private Connection connection;
    Statement stm;

    public MySQLConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "Sakec@mini4");
            stm = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Statement getStatement() {
        return stm;
    }

    public void close() {
        try {
            if (stm != null) {
                stm.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public static void main(String[] args) {
        // This is just for testing the MySQLConnection class
        MySQLConnection connection = new MySQLConnection();
        Statement stm = connection.getStatement();

       
        connection.close();
    }

}
