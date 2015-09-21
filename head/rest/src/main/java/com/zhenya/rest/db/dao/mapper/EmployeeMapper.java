package com.zhenya.rest.db.dao.mapper;

import com.zhenya.model.db.entity.Employee;

import java.util.Date;
import java.util.List;


public interface EmployeeMapper {

    public List<Employee> getAll();

    public Employee getById(long id);

    public long delete(long id);

    public long update(Employee employee);

    public long insert(Employee employee);

    public List<Employee> findOfBirth(Date birth);
    
   
}
