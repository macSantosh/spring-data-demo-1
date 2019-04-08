package com.san.springws_test.restService;

import java.util.List;
import java.util.Optional;

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
@RequestMapping("/employee")
public class EmployeeDetailControler {

	@Autowired
	EmployeeService employeeService;
	/**
	 * rest get method to accept json request and return json response
	 * @param userRequest = {"name":"santosh", deptId:"deptId"};
	 * @return userResponse
	 */
	@GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
	 public List<Employee> getEmployees(){
		return employeeService.getAllEmployees();
	 }
	
	@PutMapping(value="/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody  Employee saveEmployee(@RequestBody Employee employee) {
		
		return employeeService.save(employee);
	}
	
	@GetMapping(value="/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	 public Employee getEmployee(@PathVariable String name){
		return employeeService.getEmployee(name);
	 }
	
	@GetMapping(value="/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	 public Employee getEmployee(@PathVariable long id){
		return employeeService.getEmployee(id);
	 }
	
	
}
