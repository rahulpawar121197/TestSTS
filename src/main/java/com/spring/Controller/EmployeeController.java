package com.spring.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Service.ImplementedEmployeeService;
import com.spring.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
ImplementedEmployeeService impEmpService;
	
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployeeData(@RequestBody Employee employee){
		
		Employee emp=impEmpService.saveEmployee(employee);
		
		
		return ResponseEntity.ok().body(emp);
	}	
		@GetMapping("/get/{id}")
		public ResponseEntity<Optional<Employee>> getEmployeeData(@PathVariable("id") Integer Id){
			
			Optional<Employee> emp=impEmpService.getEmployee(Id);
			
			
			return ResponseEntity.ok().body(emp);
			
		
		}
		
		@GetMapping("/getAll")
		public ResponseEntity<List<Employee>> getAllEmployeeData(){
			List<Employee> emplist = impEmpService.getAllEmployee();
						
			return ResponseEntity.ok().body(emplist);
			
		
		}
		@DeleteMapping("/delete/{id}")
		public void deleteEmployeeData(@PathVariable("id" ) Integer Id)
		{
			
			
			impEmpService.deleteById(Id);
			
			
		}
		@PutMapping("/update/{Id}")
		
    public ResponseEntity <Employee >updateEmployee(@PathVariable("Id") Integer Id,@RequestBody Employee employee) {
    	
    	
    	Employee emp = impEmpService.updateEmployee(Id, employee);
    	
    	
    	
    	return ResponseEntity.ok().body(emp);
    	
    	
    }
		
		@GetMapping("/getByLastname/{lastname}")
		public ResponseEntity<Employee> getByLastName(@PathVariable	("lastname") String lastname){
			
			Employee emp=impEmpService.getEmployeeByLastname(lastname);
			return ResponseEntity.ok().body(emp);
			
			
			
		}	
		
		@PutMapping("/updatebynative")
		
		public void updateByNativeQuery() {
			
			
			impEmpService.updateByNativeQuery();
			
			
		}
		
@PutMapping("/insertbynative")
		
		public void insertByNativeQuery() {
			
			
			impEmpService.insertByNativeQuery();
			
			
		}
}
	

