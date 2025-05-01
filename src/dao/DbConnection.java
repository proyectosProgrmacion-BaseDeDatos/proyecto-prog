package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static String bd = "plataforma_juegos";
    private static String parametros = "?useSSL=false&serverTimezone=UTC";
    private static String user = "root";
    private static String password = "";
    private static String url = "jdbc:mysql://localhost:3306/" + bd + parametros;

    private DbConnection() {

    }

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, user, password);

    }
   

}