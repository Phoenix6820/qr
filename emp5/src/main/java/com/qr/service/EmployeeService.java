package com.qr.service;

import com.qr.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> search();

    public boolean add(Employee emp);

    public Employee search(int id);

    public boolean update(Employee emp);

    public boolean delete(int id);
}
