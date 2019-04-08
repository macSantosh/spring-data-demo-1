package com.san.springws_test.restService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.san.springws_test.model.Employee;
import com.san.springws_test.model.EmployeeRequest;
import com.san.springws_test.model.EmployeeResponse;

@RestController
@RequestMapping("/employee")
public class EmployeeDetailsRestService {

	
	/**
	 * rest get method to accept json request and return json response
	 * http://localhost:8080/springws-test/employee/getAll
	 * @param userRequest = {"name":"santosh", dept:10};
	 * @return userResponse = {"employees":[{"name":"santosh","dept":10,"salary":90000.0},{"name":"laxmi","dept":10,"salary":80000.0}]}
	 */
	
	@RequestMapping(value="/getAll", method=RequestMethod.POST)
	 public EmployeeResponse getEmployees(@RequestBody EmployeeRequest request){
		System.out.println("in get All "+ request.getName());
		EmployeeResponse response = new EmployeeResponse();
		
		List<Employee> empList = getAllEmployees();
		
		List<Employee> sanList = empList.stream().filter(x -> x.getDept() == request.getDept()).collect(Collectors.toList());
		if(request.getName() != null && !request.getName().isEmpty()){
			sanList = sanList.stream().filter(x -> x.getName().equalsIgnoreCase(request.getName())).collect(Collectors.toList());
		}
		response.setEmployees(sanList);
		 
		return response;
	 }
	
	public List<Employee> getAllEmployees(){
		List<Employee> empList = new ArrayList<>();
		
		Employee emp = new Employee();
		emp.setName( "santosh");
		emp.setDept(10);
		emp.setSalary(90000.00);
		
		empList.add(emp);
		
		emp = new Employee();
		emp.setName( "tejas");
		emp.setDept(11);
		emp.setSalary(70000.00);
		
		empList.add(emp);
		
		 emp = new Employee();
		emp.setName( "laxmi");
		emp.setDept(10);
		emp.setSalary(80000.00);
		
		empList.add(emp);
		
		return empList;
	}
}
