package com.spring.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.spring.Repository.EmployeeRepository1;
import com.spring.model.Employee;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class TestImplementedEmployeeSerrvice {
	@InjectMocks
	EmployeService employeeService;
	@Mock
	EmployeeRepository1 emprepository;
	
	
	
	public void saveEmployeeTest() {
		
		
		Employee employee=new Employee();
		employee.setId(3);
		employee.setFirstname("rahul");
		employee.setLastname("pawar");
		
		when(emprepository.save(employee)).thenReturn(employee);
		
		assertEquals(employee,employeeService.saveEmployee(employee));
		
		
	}
	

}
