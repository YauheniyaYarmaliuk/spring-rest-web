package com.zhenya.rest.controller;

import com.zhenya.model.db.entity.Department;
import com.zhenya.rest.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Department> getAll() {
		return departmentService.getAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Department getDepartment(@PathVariable Integer id) {
		return departmentService.getById(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public long update(@RequestBody Department department) {
		Department dbDepartment = departmentService.getById(department.getId());
		dbDepartment.setName(department.getName());
		return departmentService.update(dbDepartment);
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public long delete(@PathVariable Integer id) {
		return departmentService.delete(id);
	}

	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	@ResponseBody
	public long insert(@RequestBody Department department) {
		return departmentService.insert(department);
	}

}
