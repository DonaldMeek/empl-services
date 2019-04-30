package com.meek.donald.employees;

import com.meek.donald.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	Employee getEmployeeById(String employeeId);
	
}
