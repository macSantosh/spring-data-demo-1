package com.san.springws_test.service;

import java.util.List;
import java.util.Optional;

import com.san.springws_test.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public Employee save(Employee employee);
	
	public Employee getEmployee(String name);
	
	public Employee getEmployee(long id); 

}
