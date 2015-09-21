package com.zhenya.rest.service.impl;

import com.zhenya.rest.db.dao.mapper.EmployeeMapper;
import com.zhenya.model.db.entity.Employee;
import com.zhenya.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Transactional(readOnly = true)
    @Override
    public List<Employee> getAll() {
        return employeeMapper.getAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Employee getById(long id) {
        return employeeMapper.getById(id);
    }

    @Override
    public long insert(Employee employee) {
        return employeeMapper.insert(employee);
    }

    @Override
    public long update(Employee employee) {
        return employeeMapper.update(employee);
    }

    @Override
    public long delete(long id) {
        return employeeMapper.delete(id);

    }

    @Override
    public List<Employee> findOfBirth(Date birth) {
        return employeeMapper.findOfBirth(birth);
    }

   
}