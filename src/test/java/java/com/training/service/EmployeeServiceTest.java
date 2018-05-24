package com.training.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.training.repository.EmployeeRepositoryImpl;
import com.traning.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/testApplicationContext.xml"})
public class EmployeeServiceTest {
	
	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;
	
	@Mock
	EmployeeRepositoryImpl employeeRepository;
	
	List<Employee> empList;
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		empList = new ArrayList<>();
		Employee employee = new Employee();
		employee.setFirstName("Kush");
		employee.setLastName("Batra");
		empList.add(employee);		
		
		Mockito.when(employeeRepository.findAll()).thenReturn(empList);
	}
	
	@Test
	public void findTest() throws Exception {
		List<Employee> employees = employeeServiceImpl.findAll();
		Assert.assertEquals(empList.get(0).getFirstName(),employees.get(0).getFirstName());
	}
	
	@Test(expected = RuntimeException.class)
	public void returnDataTest() {
		employeeServiceImpl.returnData();
	}

}
