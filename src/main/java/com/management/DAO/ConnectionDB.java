package com.management.DAO;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionDB {
    private static Connection connection = null;
    static final String dbUrl = "jdbc:mysql://localhost:3306/s03_prog02_database";
    static final String userDb = "root";
    static final String passDb = "root";

    public static Connection conect() {
        try {
            connection = DriverManager.getConnection(dbUrl, userDb, passDb);
            System.out.println("connection ok!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static void desconectDB(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Connection getConnection(){
        if(connection == null)
            conect();
        return connection;
    }
}
