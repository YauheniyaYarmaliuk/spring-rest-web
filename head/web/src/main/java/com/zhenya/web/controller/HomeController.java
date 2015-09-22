package com.zhenya.web.controller;


import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
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
	
	
	@Resource(name="myProperties")
	 private Properties myProperties;
    
	 String URL1, URL2, URL3, URL4, URL5, URL6, URL7, URL8;
	
	@PostConstruct
	  public void init() {
         URL1 = myProperties.getProperty("my.URL1");
         URL2 = myProperties.getProperty("my.URL2");
         URL3 = myProperties.getProperty("my.URL3");
         URL4 = myProperties.getProperty("my.URL4");
         URL5 = myProperties.getProperty("my.URL5");
         URL6 = myProperties.getProperty("my.URL6");
         URL7 = myProperties.getProperty("my.URL7");
         URL8 = myProperties.getProperty("my.URL8");
	}
        
	
	@Autowired
	RestTemplate restTemplate = new RestTemplate();

	@RequestMapping("/department")
	ModelAndView listDepartments() {
		List<LinkedHashMap> departments = restTemplate.getForObject(URL1, List.class);
		return new ModelAndView("department", "departments", departments);

	}

	@RequestMapping("/employee")
	ModelAndView listEmployees() {
		List<LinkedHashMap> employees = restTemplate.getForObject(URL2, List.class);
		return new ModelAndView("employee", "employees", employees);

	}
	
	@RequestMapping("/avgSalary")
	ModelAndView listAvg() {
		List<LinkedHashMap> avgSalary = restTemplate.getForObject(URL3, List.class);
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
		Employee employees = restTemplate.postForObject(URL4, employee, Employee.class);
		return employees;
	}
	
	@RequestMapping(value = "/employee/delete/{id}")
	@ResponseBody
	private void deleteEmployee(@PathVariable Integer id) {
	    Map<String, Integer> params = new HashMap<String, Integer>();
	    params.put("id", id);
	    restTemplate.delete (URL5,  params );
	   
	}
	 
	@RequestMapping("/searchBirth")
	@ResponseBody
	 ModelAndView searchBirth(@RequestParam("birth") String birth, Model model) {
		model.addAttribute("birth",birth);
		List<LinkedHashMap> search = restTemplate.getForObject(URL6, List.class, birth);
		return new ModelAndView("searchBirth", "search", search);
	}
	
	
	@RequestMapping(value = "/department/insert/{name}")
	@ResponseBody
	public Department insert(@PathVariable("name") String name) {
		Department department = new Department();
		department.setName(name);
		Department departments = restTemplate.postForObject(URL7, department, Department.class);
		return departments;
	
	}
	
	@RequestMapping(value = "/department/delete/{id}")
	@ResponseBody
	private   void deleteDepartment(@PathVariable Integer id) {
	    Map<String, Integer> params = new HashMap<String, Integer>();
	    params.put("id", id);
	    restTemplate.delete(URL8,  params );
	   
	}

}
