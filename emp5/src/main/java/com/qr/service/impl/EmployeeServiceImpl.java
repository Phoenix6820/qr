package com.qr.service.impl;

import com.qr.dao.EmployeeDao;
import com.qr.entity.Employee;
import com.qr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Transient;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDao empDao;
    @Override
    public List<Employee> search() {
        return empDao.search();
    }

    @Override
    public boolean add(Employee emp) {
        return  empDao.add(emp)>0;
    }

    @Override

    public Employee search(int id) {

        return empDao.search(id);
    }


    @Override
    public boolean update(Employee emp) {
        return empDao.update(emp)>0;
    }

    @Override
    public boolean delete(int id) {
        return empDao.delete(id)>0;
    }
}
