package com.zp.generatecode.utils;

import com.zp.generatecode.model.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author zp
 * @create 2021/2/19 15:42
 */
public class DBUtil {
    private DB db;
    private static Connection connection;

    public static Connection getConnection(DB db) {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(db.getUrl(), db.getUsername(), db.getPassword());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;

    }
}
