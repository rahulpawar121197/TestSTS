package com.spring.Service;

import java.util.List;
import java.util.Optional;

import com.spring.model.Employee;

public interface EmployeService {

	public Employee saveEmployee(Employee employee);
	public Optional<Employee> getEmployee(Integer Id);
	public List<Employee> getAllEmployee();
	public void deleteById(Integer Id);
	public Employee updateEmployee(Integer Id,Employee employee);
	
	public Employee getEmployeeByLastname(String lastname);
	
	public void updateByNativeQuery();
	public void insertByNativeQuery();
}
