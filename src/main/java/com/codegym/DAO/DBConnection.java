package com.codegym.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/product_management";
    public static final String JDBC_USERNAME = "root";
    public static final String JDBC_PASSWORD = "123456";
    public static final String MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(MYSQL_JDBC_DRIVER);
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
