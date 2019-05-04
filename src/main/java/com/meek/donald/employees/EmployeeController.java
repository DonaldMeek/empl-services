package com.meek.donald.employees;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meek.donald.common.SerializationUtil;
import com.meek.donald.model.employee.EmployeeModel;
import com.meek.donald.model.employee.Employee;
import com.meek.donald.model.employee.EmployeeTransformer;

@RestController
@RequestMapping("/service")
public class EmployeeController {
		
	@Autowired
	private EmployeeServiceImpl emplService;

	@PostMapping(value="/empl", consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String saveEmployee(@RequestBody String empl) {
		Employee employee = null;
		try {
			employee = (Employee) SerializationUtil.getBean(
					empl, Employee.class);
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
	
	@RequestMapping(value="/empl/id", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> getEmployeeById(
			@RequestBody String request) {
		Object employeeId = null;
		try {
			employeeId = ((Employee) SerializationUtil.getBean(
					request, Employee.class)).getEmplid();
			return new ResponseEntity<String>(SerializationUtil.getJson(
					emplService.getEmployeeById(employeeId.toString())), 
					HttpStatus.OK);
			} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@PostMapping("/empl/example")
	public @ResponseBody String getEmployeeByExample(@RequestBody String empl) {
		Employee employee = null;
		EmployeeModel employeeModel = null;
		try {
			employeeModel = new ObjectMapper().readValue(empl, 
					EmployeeModel.class);
			employee = EmployeeTransformer.transformEmployeeModel(
					employeeModel);
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
