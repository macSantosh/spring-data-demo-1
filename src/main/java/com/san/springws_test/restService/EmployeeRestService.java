package com.san.springws_test.restService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.san.springws_test.model.Employee;
import com.san.springws_test.service.EmployeeService;

@RestController
//@RequestMapping("/employee")
public class EmployeeRestService {

	@Autowired
	EmployeeService employeeService;
	/**
	 * rest get method to return all employees
	 * @return userResponse list of all employees
	 */
	@GetMapping(value="/employee/all", produces = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody List<Employee> getEmployees(){
		return employeeService.getAllEmployees();
	 }
	
	@PostMapping(value="/employee/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Employee createEmployee(@RequestBody Employee employee) {
		Employee emp = employeeService.save(employee);
		return emp;
	}
	
	@GetMapping(value="/employee/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	 public Employee getEmployee(@PathVariable String name){
		return employeeService.getEmployee(name);
	 }
	
	@GetMapping(value="/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	 public Employee getEmployee(@PathVariable long id){
		return employeeService.getEmployee(id);
	 }
	
	
}
