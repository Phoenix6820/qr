package com.qr.dao;

import com.qr.entity.Department;
import com.qr.entity.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao extends  BaseDao{


    public List<Department> search() {
        List<Department> list = new ArrayList<>();
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stat = conn.createStatement();
            String sql="select * from Department";
            rs = stat.executeQuery(sql);
            while (rs.next()) {

                Department dep=new Department();
                dep.setId(rs.getInt("id"));
                dep.setName(rs.getString("name"));
                list.add(dep);

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, stat, rs);

        }
        return list;
    }

    public boolean add(Department dep) {
        List<Department> list = new ArrayList<>();
        Connection conn = null;
        Statement stat = null;
        int rs = 0;
        try {
            conn = getConnection();
            stat = conn.createStatement();
            String sql = "insert into department (name) values('" + dep.getName() + "')";
            rs = stat.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, stat, null);

        }
        return rs > 0;
    }

    public Department search(int id) {
        Department dep = new Department();
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from department where id=" + id);
            while (rs.next()) {
                dep.setId(rs.getInt("id"));
                dep.setName(rs.getString("name"));



            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, stat, rs);

        }
        return dep;

    }

    public boolean update(Department dep) {
        List<Department> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stat = null;
        int rs = 0;
        try {
            conn = getConnection();
            String sql = "update department set name=? where id=?";
            stat = conn.prepareStatement(sql);
            stat.setString(1, dep.getName());
            stat.setInt(2, dep.getId());

            rs = stat.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, stat, null);

        }
        return rs > 0;
    }



    public boolean delete(int id) {
        List<Department> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stat = null;
        int rs = 0;
        try {
            conn = getConnection();
        //    conn.setAutoCommit(false);
            String sql = "delete from department  where id=?";
            stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            rs = stat.executeUpdate();
            stat.close();
            String sql1 = "update emfployee set d_id=null where  d_id=?";
            stat = conn.prepareStatement(sql1);
            stat.setInt(1, id);
            rs = stat.executeUpdate();
        //    conn.commit();
         //   conn.setAutoCommit(true);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
//            try {
//                conn.rollback();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
        } finally {
            closeAll(conn, stat, null);

        }
        return rs > 0;
    }
}
