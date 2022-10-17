package com.transportsystem.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static Connection con = null;

    static {
        String url = "jdbc:mysql:// localhost:3306/org";
        String user = "root";
        String pass = "@root123";

        try {
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("****************** CONNECTED TO DB ******************");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("****************** ERROR NO CONNECTION ******************");

        }
    }

    public static Connection getConnection() {
        return con;
    }
}