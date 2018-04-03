package com.training.repository;

import java.util.List;

import com.training.model.Employee;

public interface EmployeeRepository {

	List<Employee> findAll();

}