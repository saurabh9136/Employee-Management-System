package com.assign.em.service;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Pageable;
import com.assign.em.entity.Employee;


@ComponentScan
public interface FilterNPaginationService {

	// creating an API as per problem statement(Filter & Pagination)
	List<Employee> getEmployeesByFilter(String department, String position, Pageable pagination_limit);

	List<Employee> getEmployeesByPagination(int numberOfRecords);
}
