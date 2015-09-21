package com.zhenya.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhenya.model.db.entity.AvgSalary;
import com.zhenya.rest.db.dao.mapper.AvgSalaryMapper;
import com.zhenya.rest.service.AvgSalaryService;

@Transactional
@Service
public class AvgSalaryServiceImpl implements AvgSalaryService {
	
	@Autowired
    private AvgSalaryMapper avgSalaryMapper;

    @Transactional(readOnly = true)
    @Override
    public List<AvgSalary> getAll() {
        return avgSalaryMapper.getAll();
    }
}
