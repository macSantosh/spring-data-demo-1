package com.san.springws_test.service;

import java.util.List;

import com.san.springws_test.model.JiraTask;

public interface TaskService {
	
	public JiraTask getTask(long id);
	
	public JiraTask createTask(long empId, JiraTask task) throws Exception;
	
	public JiraTask updateTask(long empId, long taskId, JiraTask task) throws Exception;
	
	public List<JiraTask> getTaskByEmployeeId(long empId);
	
}
