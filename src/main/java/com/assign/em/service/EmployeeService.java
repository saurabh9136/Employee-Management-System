package com.assign.em.service;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartFile;

import com.assign.em.entity.Employee;

@ComponentScan
public interface EmployeeService {

	// CRUD operations as per problem
	public List<Employee> getAllEmployees();

	public Employee getEmployeeByID(Long id);

	public boolean saveEmployee(Employee employee, MultipartFile file);

	public boolean updateEmployee(Employee employee, MultipartFile file);

	public boolean deleteEmployeeByID(Long ID);

}
