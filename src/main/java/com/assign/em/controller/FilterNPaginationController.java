package com.assign.em.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.assign.em.entity.Employee;
import com.assign.em.filter.FilterEmployee;
import com.assign.em.service.FilterNPaginationService;

@RestController
@RequestMapping("/api/employees") // this is the rest controller for pagination & filter
public class FilterNPaginationController {

	@Autowired
	private FilterNPaginationService service;

	/*
	 * ResponseEntity is an extension of the HttpEntity class that adds an HTTP
	 * status code Pageable represent a set of pages to be printed simply pagination
	 */

	@PostMapping("/filter")
	public ResponseEntity<List<Employee>> filterEmployees(@RequestBody FilterEmployee filter) {

		String department = filter.getDepartment();
		String position = filter.getPosition();
		int pagination_limit = filter.getPaginationLimit();
		Pageable pageable = PageRequest.of(0, pagination_limit);

		List<Employee> filteredEmployees = service.getEmployeesByFilter(department, position, pageable);
		return ResponseEntity.ok(filteredEmployees);
	}

	@GetMapping("/pagination")
	public ResponseEntity<List<Employee>> getEmployeesByPagination(@RequestParam(defaultValue = "10") int records) {
		try {
			List<Employee> paginatedEmployees = service.getEmployeesByPagination(records);
			return new ResponseEntity<>(paginatedEmployees, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
