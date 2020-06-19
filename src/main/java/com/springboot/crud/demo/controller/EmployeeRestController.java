package com.springboot.crud.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.crud.demo.Dao.EmployeeDao;
import com.springboot.crud.demo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeDao empDao;
	
	@Autowired
	public EmployeeRestController(EmployeeDao employeeDao)
	{
		this.empDao = employeeDao;
	}
	@GetMapping("/employees")
	public List<Employee> getEmployees()
	{
		return empDao.getAllEmployees();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeId(@PathVariable int employeeId)
	{
		return empDao.getEmployeeById(employeeId);
	}
}
