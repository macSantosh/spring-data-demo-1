package com.san.springws_test.restService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.san.springws_test.model.JiraTask;
import com.san.springws_test.service.TaskService;

@RestController
public class TaskRestService {
	
	@Autowired
	TaskService taskService;
	
	@GetMapping(value="/task/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	 public JiraTask getTask(@PathVariable long id){
		return taskService.getTask(id);
	 }
	
	@GetMapping(value="/employee/{empid}/task", produces = MediaType.APPLICATION_JSON_VALUE)
	 public List<JiraTask> getEmployeeTask(@PathVariable long empid){
		return taskService.getTaskByEmployeeId(empid);
	 }
	
	@PostMapping(value="/employee/{empid}/task", produces = MediaType.APPLICATION_JSON_VALUE)
	 public JiraTask createTask(@PathVariable long empid, @RequestBody JiraTask taskRequest) throws Exception{
		return taskService.createTask(empid, taskRequest);
	 }
	
	@PutMapping(value="/employee/{empid}/task/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE)
	 public JiraTask updateTask(@PathVariable long empid, @PathVariable long taskId, @RequestBody JiraTask taskRequest) throws Exception{
		return taskService.updateTask(empid, taskId, taskRequest);
	 }
	
}
