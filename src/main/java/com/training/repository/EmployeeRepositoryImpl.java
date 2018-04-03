package com.training.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.training.model.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	/* (non-Javadoc)
	 * @see com.training.repository.EmployeeRepository#findAll()
	 */
	@Override
	public List<Employee> findAll() {
		List<Employee> empList = new ArrayList<>();
		Employee employee = new Employee();
		employee.setFirstName("Kush");
		employee.setLastName("Batra");
		empList.add(employee);
		return empList;
	}
}
