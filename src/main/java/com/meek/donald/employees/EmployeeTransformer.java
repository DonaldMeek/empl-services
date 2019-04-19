package com.meek.donald.employees;

import com.meek.donald.Employee;

public class EmployeeTransformer {

	public static Employee transformEmployeeModel(EmployeeModel emplModel) {
		Employee employee = new Employee();
		employee.setAddr(emplModel.getAddr());
		employee.setDept(emplModel.getDept());
		employee.setEmplid(emplModel.getEmplid());
		employee.setEmplsNum(emplModel.getEmplsNum());
		employee.setName(emplModel.getName());
		employee.setSoch(emplModel.getSoch());
		return employee;
	}
}
