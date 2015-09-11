package org.rbkpro.javacf.messenger.service;


import java.util.ArrayList;
import java.util.Map;

import org.rbkpro.javacf.messenger.database.FetchDatabase;
import org.rbkpro.javacf.messenger.model.Employee;



public class EmployeeService  {
	
	private Map<String, Employee> employees ;
	private FetchDatabase fetchDatabase;
	
	public EmployeeService () throws Exception {
		this.fetchDatabase= new FetchDatabase();
		employees=fetchDatabase.getEmployees();
	}
	
	public ArrayList<Employee> getAllEmployees() throws Exception{
		System.out.print("size list employees :"+employees.size());
		return new ArrayList<Employee>(fetchDatabase.getEmployees().values());
 	}
	
	public Employee getEmployee(String employeeName){
		return employees.get(employeeName);
	}
	
	
	public Employee addEmployee(Employee employee) {
		employees.put(employee.getLast_name(), employee);
		return employee;
	}
	
	public Employee updateEmployee(Employee employee) {
		if(employee.getLast_name().isEmpty()){
			return null;
		}
		 employees.put(employee.getLast_name(), employee);
		 return employee;
	}
	
	public void removeEmployee() throws Exception{
		fetchDatabase.emptyEmployees();	
	}
	
	
	public int insertEmployees() throws Exception{
		int nbr_employees;
		nbr_employees= fetchDatabase.insertEmployees();
		return nbr_employees;
	}

}
