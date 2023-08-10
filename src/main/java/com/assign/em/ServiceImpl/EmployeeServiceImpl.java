package com.assign.em.ServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import com.assign.em.entity.Employee;
import com.assign.em.repository.EmployeeRepository;
import com.assign.em.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// Autowired to inject the EmployeeRepository bean.
	@Autowired
	private EmployeeRepository repository;

	@Override
	public List<Employee> getAllEmployees() {

		return repository.findAll(); // return all employees
	}

	@Override
	public Employee getEmployeeByID(Long id) {

		return repository.findById(id).get(); // return employee by ID
	}

	public boolean deleteEmployeeByID(Long ID) {
		Employee employee = repository.findById(ID).orElse(null);
		if (employee == null) {
			// Employee not found, nothing to delete
			return false;
		}

		// Get the image filename from the employee's data
		String filename = employee.getPicture();

		// Delete the employee from the database
		repository.deleteById(ID);

		// Check if the employee is still present in the database
		boolean employeeExists = repository.existsById(ID);

		if (!employeeExists) {
			// If the employee is no longer present in the database, proceed to delete the
			// image file
			try {
				Path imagePath = Paths.get(uploadDirectory, filename);
				Files.delete(imagePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return !employeeExists;
	}

	// setting up a path to store images
	public static String uploadDirectory = Paths
			.get(System.getProperty("user.dir"), "src", "main", "webapp", "imagedata").toString();

	@Override
	public boolean saveEmployee(Employee employee, MultipartFile file) {
		try {
			String filename = System.currentTimeMillis() + "-" + file.getOriginalFilename(); // save filename with
																								// unique name
			Path fileNameAndPath = Paths.get(uploadDirectory, filename);
			Files.write(fileNameAndPath, file.getBytes());
			employee.setPicture(filename);

			Employee updatedEmp = repository.save(employee);

			// Check if the employee is successfully saved or updated
			return repository.findById(updatedEmp.getId()).isPresent();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateEmployee(Employee employee, MultipartFile file) {
		try {
			// Check if a new image is uploaded or not
			if (!file.isEmpty()) {
				// New image is uploaded, process and save it
				String filename = System.currentTimeMillis() + "-" + file.getOriginalFilename();
				Path fileNameAndPath = Paths.get(uploadDirectory, filename);
				Files.write(fileNameAndPath, file.getBytes());
				employee.setPicture(filename);
			} else {
				// No new image uploaded, retain the existing image
				Employee existingEmployee = repository.findById(employee.getId()).orElse(null);
				if (existingEmployee != null) {
					employee.setPicture(existingEmployee.getPicture());
				}
			}

			Employee updatedEmp = repository.save(employee);

			// Check if the employee is successfully saved or updated
			return repository.findById(updatedEmp.getId()).isPresent();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
