package com.assign.em.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.assign.em.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// below repositories are used for filter in different scenarios
	List<Employee> findByDepartmentOrPosition(String department, String position, Pageable pageable);

	List<Employee> findByDepartment(String department, Pageable pagination_limit);

	List<Employee> findByPosition(String position, Pageable pagination_limit);
}
