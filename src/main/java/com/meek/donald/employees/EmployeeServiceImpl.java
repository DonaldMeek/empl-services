package com.meek.donald.employees;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meek.donald.Employee;
import com.meek.donald.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Optional<Employee> getEmployeeByExample(Employee employee) {
		//TODO use custom query
		//		employee = employeeRepository.(employee);
		//		return employee;
		return null;
	}
	
	public Optional<Employee> getEmployeeById(String employeeId) {
		return employeeRepository.findById(
				Integer.getInteger(employeeId));
	}
}
