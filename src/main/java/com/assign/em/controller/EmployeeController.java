package com.assign.em.controller;

import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.assign.em.entity.Employee;
import com.assign.em.service.EmployeeService;

@Controller // controller for all web related api's
public class EmployeeController {

	@Autowired
	private EmployeeService service; // to use its properties

	@GetMapping("/")
	public String homePage() {
		return "Home"; // Home page
	}

	// below controller to get all eployees
	@GetMapping("viewEmployeeList")
	public String viewEmployeeList(@ModelAttribute("message") String message, Model model) {
		model.addAttribute("employeeList", service.getAllEmployees());
		model.addAttribute("message", message);

		return "ViewEmployeeList";
	}

	// setting up a path to store images
	public static String uploadDirectory = Paths
			.get(System.getProperty("user.dir"), "src", "main", "webapp", "imagedata").toString();

	/*
	 * model represent a Java object carrying data addAttribute() purpose is to add
	 * values in the model that will be identiied globally
	 */
	@GetMapping("/addEmployee")
	public String addEmployee(@ModelAttribute("message") String message, Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("message", message);

		return "AddEmployee";
	}

	/*
	 * @RequestParam takes an body in input Redirect Modules are used to store flash
	 * attributes
	 */

	@PostMapping("/saveEmployee")
	public String saveEmployee(Employee employee, @RequestParam("file") MultipartFile file,
			RedirectAttributes attributes) {
		if (service.saveEmployee(employee, file)) {
			attributes.addFlashAttribute("message", "save success");
			return "redirect:/viewEmployeeList";
		}

		attributes.addFlashAttribute("message", "save failure");
		return "redirect:/addEmployee";
	}

	@GetMapping("/editEmployee/{id}")
	public String editEmployee(@PathVariable Long id, Model model) {
		Employee employee = service.getEmployeeByID(id);

		// if the employee has an existing picture
		if (employee.getPicture() != null) {
			// If a picture exists, set a flag to indicate the image should not be updated
			model.addAttribute("updateImage", false);
		} else {
			// If no picture exists, set the flag to indicate the image can be updated
			model.addAttribute("updateImage", true);
		}

		model.addAttribute("employee", employee);

		return "EditEmployee";
	}

	@PostMapping("/editSaveEmployee")
	public String editSaveEmployee(Employee employee, @RequestParam("file") MultipartFile file,
			RedirectAttributes attributes) {
		if (service.updateEmployee(employee, file)) {
			attributes.addFlashAttribute("message", "Edit success");
			return "redirect:/viewEmployeeList";
		}

		attributes.addFlashAttribute("message", "Edit failure");
		return "redirect:/editEmployee/" + employee.getId();
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Long id, RedirectAttributes attributes) {
		if (service.deleteEmployeeByID(id)) {
			attributes.addFlashAttribute("message", "Delete success");
		} else {
			attributes.addFlashAttribute("message", "Delete failure");
		}

		return "redirect:/viewEmployeeList";
	}

}
