package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {

    public static Connection getConnection() {
        String url = "jdbc:sqlite:src/db/fruits.db";
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            conn = null;
        }
        return conn;
    }
}
