package com.spring.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.spring.Repository.EmployeeRepository;
import com.spring.Repository.EmployeeRepository1;
import com.spring.model.Employee;
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)

class TestImplementedEmployeeService {

	@InjectMocks
	ImplementedEmployeeService employeeService;
	@Mock
	EmployeeRepository1 emprepository;
	@Mock
	
	EmployeeRepository obj;
	
	@Test
	void testSaveEmployee() {
		Employee employee=new Employee();
		employee.setId(3);
		employee.setFirstname("rahul");
		employee.setLastname("pawar");
		
		when(emprepository.save(employee)).thenReturn(employee);
		
		assertEquals(employee,employeeService.saveEmployee(employee));
		

	}
	
	@Test
	public void testGetAllEmployee() {
		
		
	Employee emp=new Employee();
		emp.setId(1);
		emp.setFirstname("rahul");
		emp.setLastname("pawar");
		
		
		Employee emp2=new Employee();
		
		emp2.setId(2);
		emp2.setFirstname("vishal");
		emp2.setLastname("pawar");
		
		List<Employee> list=new ArrayList();
		
		list.add(emp);
		list.add(emp2);
		
		
		
		
		when(emprepository.findAll()).thenReturn(list);
		
		assertEquals(list,employeeService.getAllEmployee());
		
		
	}
	
	
	@Test
	public void testUpdateEmployeeIfIdExistAndFirstnameNotnull() {
		
		int Id=1;
		
		Employee employee=new Employee();
		 employee.setId(1);
		 employee.setFirstname("rahul");
		 employee.setLastname("pawar");
		 
		 Employee emp=new Employee();
		 
		 emp.setId(1);
		 
		 emp.setFirstname("vishal");
		 emp.setLastname("babar");
		 
		 
		 when(obj.getById(Id)).thenReturn(emp);
		 
		 employeeService.updateEmployee(1,employee);
		 
		 
		 
		 doNothing().when(emp).setFirstname(employee.getFirstname());
		 verify(emp).setFirstname((employee).getFirstname());
		 
		 assertEquals(emp,employeeService.updateEmployee(1,employee));
		
		
		
		
	}

		
	

}
