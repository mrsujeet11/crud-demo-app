package com.springboot.crud.demo.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.crud.demo.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private EntityManager manager;
	
	@Autowired
	public EmployeeDaoImpl(EntityManager theManager)
	{
		this.manager = theManager;
	}
	
	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		
		Session currSession = manager.unwrap(Session.class);
		Query<Employee> myQuery = currSession.createQuery("from Employee", Employee.class);
		List<Employee> emp = myQuery.getResultList();
		return emp;
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int employeeid) {
		
		Session currSession = manager.unwrap(Session.class);
		//Query<Employee> empQuery = currSession.createQuery("from Employee where id="+employeeid, Employee.class);
		//Employee emp = empQuery.getSingleResult();
		
		//Another method
		Employee emp = currSession.get(Employee.class, employeeid);
		
		
		return emp;
	}

}
