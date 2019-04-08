package com.san.springws_test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.san.springws_test.model.Employee;
import com.san.springws_test.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Transactional
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	@Transactional
	@Override
	public Employee save(Employee employee) {
		if(employee == null) {
			return null; //error
		}
		return employeeRepository.save(employee);
	}

	@Transactional
	@Override
	public Employee getEmployee(String name) {
		return employeeRepository.findByName(name);
	}

	@Transactional
	@Override
	public Employee getEmployee(long id) {
		Optional<Employee> empOptional = employeeRepository.findById(id);
		
		if(!empOptional.isPresent()) return null;
		return empOptional.get();
		
	}

}
