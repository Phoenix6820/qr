package com.qr.dao;

import com.qr.entity.Department;
import com.qr.entity.Employee;
import com.qr.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseDao {


    public User search(User user) {
        List<Employee> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            conn = getConnection();

            String sql = "select  * from user where username=? and password=?";
            stat = conn.prepareStatement(sql);
            stat.setString(1,user.getUsername());
            stat.setString(2,user.getPassword());
            rs = stat.executeQuery();
            if (rs.next()) {
               user.setId(rs.getInt("id"));

            }else{
                user=null;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, stat, rs);

        }
        return user;
    }

}
