package com.san.springws_test.restService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping(value="/employee/{empid}/task", produces = MediaType.APPLICATION_JSON_VALUE)
	 public JiraTask createTask(@PathVariable long empid, @RequestBody JiraTask task) throws Exception{
		return taskService.createTask(empid, task);
	 }
	
}
