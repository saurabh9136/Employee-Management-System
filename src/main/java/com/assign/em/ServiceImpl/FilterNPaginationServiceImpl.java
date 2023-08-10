package com.assign.em.ServiceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.assign.em.entity.Employee;
import com.assign.em.repository.EmployeeRepository;
import com.assign.em.service.FilterNPaginationService;

@Service
public class FilterNPaginationServiceImpl implements FilterNPaginationService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public List<Employee> getEmployeesByPagination(int numberOfRecords) {
		if (numberOfRecords <= 0) {
			throw new IllegalArgumentException("Invalid number of records.");
		}

		// Fetch employees from the database based on the pagination limit
		return repository.findAll(PageRequest.of(0, numberOfRecords)).getContent();
	}

	@Override
	public List<Employee> getEmployeesByFilter(String department, String position, Pageable pagination_limit) {

		if (department != null && position != null) {
			// Search employees by department and position
			return repository.findByDepartmentOrPosition(department, position, pagination_limit);
		} else if (department != null) {
			// Search employees by department
			return repository.findByDepartment(department, pagination_limit);
		} else if (position != null) {
			// Search employees by position
			return repository.findByPosition(position, pagination_limit);
		} else {
			// Return all employees with pagination
			return repository.findAll(pagination_limit).getContent();
		}
	}
}
