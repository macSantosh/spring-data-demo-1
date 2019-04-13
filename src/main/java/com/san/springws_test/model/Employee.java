package com.san.springws_test.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Employee")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope=Integer.class)
public class Employee implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4343867162769687315L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private long id;
    
    @Column(name = "name")
	private String name;
	
    @Column(name = "role")
    private String role;
    
	@Column(name = "salary")
	private double salary;
	
	@JsonIgnore
	//@JsonManagedReference
	@OneToMany(mappedBy="employee", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Set<JiraTask> jiraTasks = new HashSet<>();
    
    public long getId() {
  		return id;
  	}
  	public void setId(long id) {
  		this.id = id;
  	}
  	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Set<JiraTask> getJiraTasks() {
		return jiraTasks;
	}
	public void setJiraTasks(Set<JiraTask> jiraTasks) {
		this.jiraTasks = jiraTasks;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + jiraTasks + ", salary=" + salary + "]";
	}
	
}
