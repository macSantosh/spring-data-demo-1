package com.san.springws_test.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.san.springws_test.model.JiraTask;

@Repository("taskRepository")
public interface TaskRepository extends JpaRepository<JiraTask, Long>{

	public List<JiraTask> findTaskByEmployeeId(long empId);
}
