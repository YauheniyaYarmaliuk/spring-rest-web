package com.zhenya.rest.controller;


import com.zhenya.model.db.entity.Employee;
import com.zhenya.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeService.getById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public long update(@RequestBody Employee employee) {
        Employee dbEmployee = employeeService.getById(employee.getId());
        dbEmployee.setName(employee.getName());
        dbEmployee.setBirth(employee.getBirth());
        dbEmployee.setSalary(employee.getSalary());
        dbEmployee.setSurname(employee.getSurname());
        return employeeService.update(dbEmployee);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public long delete(@PathVariable Integer id) {
        return employeeService.delete(id);
    }

    @RequestMapping( value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public long insert(@RequestBody Employee employee) {
        return employeeService.insert(employee);
        
    }

    public static Date getDOB(String birth) {

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/findOfBirth/{birt}", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> findOfBirth(@PathVariable String birt) {
        Date birth = getDOB(birt);
        return employeeService.findOfBirth(birth);
    }

  
}
