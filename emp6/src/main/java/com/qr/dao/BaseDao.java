package com.qr.dao;

import java.sql.*;

public class BaseDao {
    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company4", "root", "123456");
        return conn;
    }

    protected void closeAll(Connection conn, Statement stat, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
