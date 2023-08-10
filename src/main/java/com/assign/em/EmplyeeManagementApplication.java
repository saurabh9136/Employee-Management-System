package com.assign.em;

import java.io.File;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.assign.em.controller.EmployeeController;

@SpringBootApplication
public class EmplyeeManagementApplication {

	public static void main(String[] args) {
		// create a file if not exist
		new File(EmployeeController.uploadDirectory).mkdir();

		SpringApplication.run(EmplyeeManagementApplication.class, args);
	}

}
