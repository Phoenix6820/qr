package com.qr.dao;

import com.qr.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeDao {
    public List<Employee> search();

    public int add(Employee emp);

    public Employee search(int id);

    public int update(Employee emp);

    public int delete(int id);
}
