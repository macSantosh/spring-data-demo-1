package com.san.springws_test.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.san.springws_test.model.Employee;

@Repository("employeeRepository")

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	public List<Employee> findAll();
	
	public Employee save(Employee employee);
	
	public Employee findByName(String name);
}
