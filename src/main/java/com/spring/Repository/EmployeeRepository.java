package com.spring.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.spring.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Serializable> {

	public Employee getById(Integer id);
	
	@Query(value="select * from employee where lastname=?1" ,nativeQuery=true )
	public Employee getByLastname(String lastname);
	
	@Query(value="update employee set lastname='Bhosale' where id=4", nativeQuery=true)
	public void updateByNativeQuery();
	 @Query(value="insert into employee (lastname) values ('sawant') " , nativeQuery=true)
	 
	 public void insertByNativeQuery();
}