package com.san.springws_test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.san.springws_test.model.JiraTask;
import com.san.springws_test.repo.EmployeeRepository;
import com.san.springws_test.repo.TaskRepository;
import com.san.springws_test.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public JiraTask getTask(long id) {
		return taskRepository.findById(id).orElse(null);
	}
	
	public List<JiraTask> getTaskByEmployeeId(long empId){
		return taskRepository.findTaskByEmployeeId(empId);
	}
	
	public JiraTask createTask(long empId, JiraTask task) throws Exception {
		return employeeRepository.findById(empId).map(employee ->{
			task.setEmployee(employee);
			return taskRepository.save(task);
			
		}).orElseThrow(() -> new Exception("Employee id not found for task"));
				
	}
	
	/**
	 * update the task for given employee id, 
	 * throw exception if empId doesnot exist
	 */
	public JiraTask updateTask(long empId, long taskId, JiraTask task) throws Exception{
		if(!employeeRepository.existsById(empId)) {
			throw new Exception("Employee id not found for task");
		}
		return taskRepository.findById(taskId).map(tsk -> {
			tsk.setName(task.getName());
			tsk.setDescription(task.getDescription());
			return taskRepository.save(tsk);
		 }).orElseThrow(() -> new Exception("cannot save task"));
	}
	
	public JiraTask save(JiraTask task) {
		return taskRepository.save(task);
	}
}
