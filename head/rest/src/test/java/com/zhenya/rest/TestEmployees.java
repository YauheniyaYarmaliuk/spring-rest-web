package com.zhenya.rest;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.junit.Test;

import com.zhenya.model.db.entity.Employee;
import com.zhenya.rest.service.EmployeeService;
import com.zhenya.rest.service.impl.EmployeeServiceImpl;

import junit.framework.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:com/zhenya/rest/db/dao/spring/dao-context.xml"})
public class TestEmployees {

    @Autowired
    private EmployeeService service;

    @Test
    public void testEmployeeSize() {
        List<Employee> list = service.getAll();
        assertNotNull(list);
        assertTrue(list.size()>0);
    }

    @Test
    public void testEmployeeById() {
        Employee employee = service.getById(11);
        assertNotNull(employee);
    }

    @Test
    public void testEmployeeInsert() {
        Employee test = new Employee();
        test.setDeptId(1);
        test.setName("Yauheniya");
        test.setSurname("Yarmaliuk");
        test.setPatronymic("Dmitrievna");
        test.setBirth("1991-02-10");
        test.setSalary(450);
        List<Employee> list = service.getAll();
        service.insert(test);
        List<Employee> list2 = service.getAll();
        assertTrue(list2.size() > list.size());
       

    }

    @Test
    public void testEmployeeUpdate() {
        Employee insempl = service.getById(8);
        int salary = 1000;
        insempl.setSalary(salary);
        service.update(insempl);
        int var2 = service.getById(8).getSalary();
        Assert.assertEquals(salary, var2);

    }

    @Test
    public void testDelete() {
        service.delete(21);
        Employee employee = service.getById(21);
        Assert.assertEquals(true, employee == null);
    }

}
