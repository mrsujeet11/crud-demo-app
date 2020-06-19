package com.springboot.crud.demo.Dao;

import java.util.List;

import com.springboot.crud.demo.entity.Employee;

public interface EmployeeDao {

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(int employeeid);
}
