package com.meek.donald.employees;

import java.util.Optional;

import com.meek.donald.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	Optional<Employee> getEmployeeById(String employeeId);
	
}
