package com.zhenya.rest;

import com.zhenya.model.db.entity.Department;
import com.zhenya.rest.service.DepartmentService;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:com/zhenya/rest/db/dao/spring/dao-context.xml"})
public class TestDepartments {

    @Autowired
    private DepartmentService departmentService;

    @Test
    public void testDepartmentsSize() {
        List<Department> list = departmentService.getAll();

        assertNotNull(list);
        assertEquals(list.size(), 13);
    }

    @Test
    public void testDepartmentsById() {
        Department department = departmentService.getById(5);
        assertNotNull(department);
    }

    @Test
    public void testDepartmentInsert() {
        Department tester = new Department();
        tester.setName("Testers");

        List<Department> list = departmentService.getAll();

        departmentService.insert(tester);
        List<Department> list2 = departmentService.getAll();

        assertTrue(list2.size() > list.size());
    }

    @Test
    public void testDepartmentsUpdate() {
        Department insdept = departmentService.getById(14);

        String newName = "New-new name" + Math.random();

        insdept.setName(newName);

        departmentService.update(insdept);

        String var2 = departmentService.getById(14).getName();

        Assert.assertEquals(newName, var2);

    }

    @Test
    public void testInsertId() {
        Department dept = new Department();
        dept.setName("Testers");
        long id = departmentService.insert(dept);
        System.out.println(dept.getId());
    }

    @Test
    public void testDelete() {
        departmentService.delete(28);
        Department department = departmentService.getById(28);
        Assert.assertEquals(true, department == null);
    }
  
}
