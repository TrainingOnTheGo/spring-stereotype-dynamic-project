package com.training.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.training.service.EmployeeServiceImpl;
import com.traning.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/testApplicationContext.xml"})
public class EmployeeControllerTest {
	
	@InjectMocks
	private EmployeeController employeeController;
	
	@Mock
	private EmployeeServiceImpl employeeService;
	
	private MockMvc mockMvc;
	
	List<Employee> empList;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
		empList = new ArrayList<>();
		
		Employee employee = new Employee();
		employee.setFirstName("Kush1");
		employee.setLastName("Batra");
		empList.add(employee);
		Mockito.when(employeeService.findAll()).thenReturn(empList);
	}
	
	@Test
	public void findTest() throws Exception {
		System.out.println("Started");
		ResultActions resultActions = mockMvc.perform(get("/find"));
		resultActions.andExpect(status().isOk()).andExpect(jsonPath("$[0].firstName", is(empList.get(0).getFirstName())));
		System.out.println("Done");
	}
}
