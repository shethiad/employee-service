package com.ds.employeeservice;


import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    
	@Id
    @Column(name = "empid", nullable = false, length = 50)
    private String empid;

    @Column(name = "empname", length = 50)
    private String empname;

    @Column(name = "employmentdate")
    private Date employmentdate;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "role", length = 20)
    private String role;

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getEmploymentdate() {
		return employmentdate;
	}

	public void setEmploymentdate(Date employmentdate) {
		this.employmentdate = employmentdate;
	}

	
}