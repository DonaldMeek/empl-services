package com.meek.donald.employees;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meek.donald.Employee;

@RestController
@RequestMapping("/service")
public class EmployeeController {
		
	@Autowired
	private EmployeeServiceImpl emplService;

	@PostMapping("/empl")
	public @ResponseBody String saveEmployee(@RequestBody String empl) {
		Employee employee = null;
		EmployeeModel employeeModel = null;
		try {
			employeeModel = new ObjectMapper().readValue(empl, EmployeeModel.class);
			employee = EmployeeTransformer.transformEmployeeModel(employeeModel);
			employee = emplService.saveEmployee(employee);
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@GetMapping("/empl/id")
	public @ResponseBody Employee getEmployeeById(@RequestBody String emplId) {
		Optional<Employee> employee = null;
		String employeeId= null;
		try {
			employeeId = new ObjectMapper().readValue(emplId, String.class);
			employee = emplService.getEmployeeById(employeeId);
			if (employee.isPresent() == true) return employee.get();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@GetMapping("/empl/example")
	public @ResponseBody String getEmployeeByExample(@RequestBody String empl) {
		Employee employee = null;
		EmployeeModel employeeModel = null;
		try {
			employeeModel = new ObjectMapper().readValue(empl, EmployeeModel.class);
			employee = EmployeeTransformer.transformEmployeeModel(employeeModel);
			//employee = emplService.getEmployeeByExample(employee);
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
