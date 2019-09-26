package com.qr.dao;

import com.qr.entity.Department;
import com.qr.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao extends  BaseDao{


    public List<Employee> search() {
        List<Employee> list = new ArrayList<>();
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stat = conn.createStatement();
            String sql="select e.*,d.name as dName from employee as e left join department as d on e.d_id =d.id order by e.id";
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setSex(rs.getString("sex"));
                emp.setAge(rs.getInt("age"));
                Department dep=new Department();
                dep.setId(rs.getInt("d_id"));
                dep.setName(rs.getString("dName"));
                emp.setDep(dep);
                list.add(emp);

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, stat, rs);

        }
        return list;
    }

    public boolean add(Employee emp) {
        List<Employee> list = new ArrayList<>();
        Connection conn = null;
        Statement stat = null;
        int rs = 0;
        try {
            conn = getConnection();
            stat = conn.createStatement();
            String sql = "insert into employee (name,sex,age,d_id) values('" + emp.getName() + "','" + emp.getSex() + "'," + emp.getAge()
                    +","+emp.getDep().getId()+ ")";
            rs = stat.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, stat, null);

        }
        return rs > 0;
    }

    public Employee search(int id) {
        Employee emp = new Employee();
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery("select e.*,d.name as dName from employee as e left join department as d on e.d_id =d.id  where e.id=" + id);
            while (rs.next()) {
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setSex(rs.getString("sex"));
                emp.setAge(rs.getInt("age"));
                Department dep=new Department();
                dep.setId(rs.getInt("d_id"));
                dep.setName(rs.getString("dName"));
                emp.setDep(dep);

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, stat, rs);

        }
        return emp;

    }

    public boolean update(Employee emp) {
        List<Employee> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stat = null;
        int rs = 0;
        try {
            conn = getConnection();
            String sql = "update employee set name=?,sex=?,age=?,d_id=? where id=?";
            stat = conn.prepareStatement(sql);
            stat.setString(1, emp.getName());
            stat.setString(2, emp.getSex());
            stat.setInt(3, emp.getAge());
            stat.setInt(4, emp.getDep().getId());
            stat.setInt(5, emp.getId());

            rs = stat.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, stat, null);

        }
        return rs > 0;
    }






    public boolean delete(int id) {
        List<Employee> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stat = null;
        int rs = 0;
        try {
            conn = getConnection();
            String sql = "delete from employee  where id=?";
            stat = conn.prepareStatement(sql);

            stat.setInt(1, id);

            rs = stat.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, stat, null);

        }
        return rs > 0;
    }
}
