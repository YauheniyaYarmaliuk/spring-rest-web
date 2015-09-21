package com.zhenya.web.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.zhenya.model.db.entity.Department;
import com.zhenya.model.db.entity.Employee;

/**
 * Handles requests for the application home page.
 */
@Controller(value = "HomeController")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "home";
	}

	@Autowired
	RestTemplate restTemplate = new RestTemplate();

	@RequestMapping("/department")
	ModelAndView listDepartments() {
		String url = "http://localhost:8080/rest/departments";
		List<LinkedHashMap> departments = restTemplate.getForObject(url, List.class);
		return new ModelAndView("department", "departments", departments);

	}

	@RequestMapping("/employee")
	ModelAndView listEmployees() {
		String url = "http://localhost:8080/rest/employees";
		List<LinkedHashMap> employees = restTemplate.getForObject(url, List.class);
		return new ModelAndView("employee", "employees", employees);

	}
	
	@RequestMapping("/avgSalary")
	ModelAndView listAvg() {
		String url = "http://localhost:8080/rest/avgSalary";
		List<LinkedHashMap> avgSalary = restTemplate.getForObject(url, List.class);
		return new ModelAndView("avgSalary", "avgSalary", avgSalary);

	}

	@RequestMapping(value = "/employee/insert/{deptId}/{name}/{surname}/{patronymic}/{birth}/{salary}")
	@ResponseBody
	public  Employee insert(@PathVariable Integer deptId, @PathVariable String name, @PathVariable String surname,
			@PathVariable String patronymic, @PathVariable String birth, @PathVariable Integer salary) {
		Employee employee = new Employee();
		employee.setDeptId(deptId);
		employee.setName(name);
		employee.setSurname(surname);
		employee.setPatronymic(patronymic);
		employee.setBirth(birth);
		employee.setSalary(salary);
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:8080/rest/employees/post";
		Employee employees = restTemplate.postForObject( uri, employee, Employee.class);
		
		return employees;
	}
	
	@RequestMapping(value = "/employee/delete/{id}")
	@ResponseBody
	private   void deleteEmployee(@PathVariable Integer id) {
	    Map<String, Integer> params = new HashMap<String, Integer>();
	    params.put("id", id);
	    final String uri = "http://localhost:8080/rest/employees/delete/{id}";
	    restTemplate.delete (uri,  params );
	   
	}
	 
	
	@RequestMapping("/searchBirth")
	@ResponseBody
	 ModelAndView searchBirth(@RequestParam("birth") String birth, Model model) {
		model.addAttribute("birth",birth);
		final String url = "http://localhost:8080/rest/employees/findOfBirth/{birt}";
		List<LinkedHashMap> search = restTemplate.getForObject(url, List.class, birth);
		return new ModelAndView("searchBirth", "search", search);
	}
	
	
	@RequestMapping(value = "/department/insert/{name}")
	@ResponseBody
	public   Department insert(@PathVariable("name") String name) {
		Department department = new Department();
		department.setName(name);
		RestTemplate restTemplate = new RestTemplate();
		final String url = "http://localhost:8080/rest/departments/insert";
		Department departments = restTemplate.postForObject(url, department, Department.class);
		return departments;
	
	}
	
	@RequestMapping(value = "/department/delete/{id}")
	@ResponseBody
	private   void deleteDepartment(@PathVariable Integer id) {
	    Map<String, Integer> params = new HashMap<String, Integer>();
	    params.put("id", id);
	    final String url =  "http://localhost:8080/rest/departments/delete/{id}";
	    restTemplate.delete(url,  params );
	   
	}

}
