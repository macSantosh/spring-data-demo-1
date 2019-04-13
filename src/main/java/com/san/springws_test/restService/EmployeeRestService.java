package com.san.springws_test.restService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@PutMapping(value="/employee/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Employee saveEmployee(@RequestBody Employee employee) {
		
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
