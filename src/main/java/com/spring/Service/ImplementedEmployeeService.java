package com.spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Repository.EmployeeRepository;
//import com.spring.Repository.EmployeeRepository;
import com.spring.Repository.EmployeeRepository1;
import com.spring.model.Employee;

@Service
public class ImplementedEmployeeService implements EmployeService {

	@Autowired
	EmployeeRepository1 emprepository;
	
	@Autowired
	EmployeeRepository obj;
	@Override
	public Employee saveEmployee(Employee employee) {
		Employee emp=emprepository.save(employee);

		return emp;
	}
	@Override
	public Optional<Employee> getEmployee(Integer Id) {
		Optional<Employee> emp = emprepository.findById(Id);
		return emp;
	}
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list = emprepository.findAll();
		return list;
	}
	@Override
	public void deleteById(Integer Id) {
		emprepository.deleteById(Id);
	
		
	}
	@Override
	 public 
	Employee updateEmployee(Integer Id,Employee employee) {
		
		if(obj.existsById(Id)) {
		Employee emp=obj.getById(Id);
		   if(employee.getFirstname()!=null)  { 
		emp.setFirstname(employee.getFirstname());
		   }
		   
		   if(employee.getLastname()!=null) {
		emp.setLastname(employee.getLastname());
		   }
		
		return obj.save(emp);
	}
		return obj.save(employee);
	
	}
	@Override
	public Employee getEmployeeByLastname(String lastname) {
	//Employee emp	=obj.getByLastname(lastname);
	
		return obj.getByLastname(lastname);}
	@Override
	public void updateByNativeQuery() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertByNativeQuery() {
		obj.insertByNativeQuery();
		
	}
	
	
	}
	
	
	
	
	

