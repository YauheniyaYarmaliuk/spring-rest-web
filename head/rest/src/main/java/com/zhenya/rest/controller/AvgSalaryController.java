package com.zhenya.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zhenya.model.db.entity.AvgSalary;
import com.zhenya.rest.service.AvgSalaryService;

@Controller
@RequestMapping("/avgSalary")
public class AvgSalaryController {

	@Autowired
	private AvgSalaryService avgSalaryService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<AvgSalary> getAll() {
		return avgSalaryService.getAll();
	}
}
