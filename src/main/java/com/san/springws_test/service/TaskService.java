package com.san.springws_test.service;

import com.san.springws_test.model.JiraTask;

public interface TaskService {
	
	public JiraTask getTask(long id);
	
	public JiraTask createTask(long empId, JiraTask task) throws Exception;
}
