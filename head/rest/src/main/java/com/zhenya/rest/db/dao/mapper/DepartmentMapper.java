package com.zhenya.rest.db.dao.mapper;

import com.zhenya.model.db.entity.Department;

import java.util.List;

public interface DepartmentMapper {

    public List<Department> getAll();

    public Department selectById(long id);

    public long delete(long id);

    public long update(Department department);

    public long insert(Department department);
}
