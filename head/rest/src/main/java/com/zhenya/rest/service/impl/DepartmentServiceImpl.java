package com.zhenya.rest.service.impl;

import com.zhenya.rest.db.dao.mapper.DepartmentMapper;
import com.zhenya.model.db.entity.Department;
import com.zhenya.rest.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Transactional(readOnly = true)
    @Override
    public List<Department> getAll() {
        return departmentMapper.getAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Department getById(long id) {
        return departmentMapper.selectById(id);
    }

    @Override
    public long insert(Department department) {
        return departmentMapper.insert(department);
    }

    @Override
    public long update(Department department) {
        return departmentMapper.update(department);
    }

    @Override
    public long delete(long id) {
        return departmentMapper.delete(id);
    }

}
