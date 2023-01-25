package com.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Employee;

public interface EmployeeRepository1 extends JpaRepository<Employee,Integer>{

}
