package com.meek.donald;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.meek.donald.model.employee.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	
	
}
