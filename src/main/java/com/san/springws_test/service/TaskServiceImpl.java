package com.san.springws_test.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.san.springws_test.model.JiraTask;
import com.san.springws_test.repo.EmployeeRepository;
import com.san.springws_test.repo.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public JiraTask getTask(long id) {
		// TODO Auto-generated method stub
		Optional<JiraTask> ojiraTask = taskRepository.findById(id);
		if(ojiraTask.isPresent()) {
			return ojiraTask.get();
		}
		return null;
	}
	
	public JiraTask createTask(long empId, JiraTask task) throws Exception {
		return employeeRepository.findById(empId).map(employee ->{
			task.setEmployee(employee);
			return taskRepository.save(task);
			
		}).orElseThrow(() -> new Exception("Employee id not found for task"));
				
	}
	public JiraTask save(JiraTask task) {
		return taskRepository.save(task);
	}
}
