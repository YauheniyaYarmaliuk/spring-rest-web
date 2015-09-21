package com.zhenya.rest.service;

import com.zhenya.model.db.entity.Department;

import java.util.List;

public interface DepartmentService {

	public List<Department> getAll();

	public Department getById(long id);

	public long insert(Department department);

	public long update(Department department);

	public long delete(long id);

}
