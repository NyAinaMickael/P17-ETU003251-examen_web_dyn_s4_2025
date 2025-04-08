package src.main.java.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private static final String url="jdbc:mysql://localhost:3306/db_s2_ETU003251";
    private static final String user="ETU003251";
    private static final String pwd="bxY0DAeq";
    // private Connection conn;
    public static Connection getConnection() throws ClassNotFoundException,SQLException
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url, user, pwd);
            return conn;
        } catch (ClassNotFoundException e) {
            // throw new Exception("Pilote JDBC introuvable.");
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
            // throw new Exception("Erreur lors de la connexion a la base");
        }
    }

}
