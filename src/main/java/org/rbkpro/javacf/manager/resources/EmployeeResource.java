package org.rbkpro.javacf.manager.resources;


import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.rbkpro.javacf.manager.model.Employee;
import org.rbkpro.javacf.manager.service.EmployeeService;

@Path("/employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {
	
	private EmployeeService EmployeeService ; 
	
	public EmployeeResource() throws Exception{
		EmployeeService = new EmployeeService();
	}
	 
	@GET
	public ArrayList<Employee> getEmployees() throws Exception {
		return EmployeeService.getAllEmployees();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("init")
	public String initDatabase() throws Exception {
		EmployeeService.emptyDatabase();
		return "Number employees inserted :"+EmployeeService.insertEmployees();
	}
		
	@POST
	public Employee addEmployee(Employee Employee){
		return EmployeeService.addEmployee(Employee);
	}
	
	@GET
	@Path("/{EmployeeName}")
	public Employee getEmployee(@PathParam("EmployeeName") String EmployeeName) throws Exception {
		return EmployeeService.getEmployee(EmployeeName);
	}
	
	@PUT
	@Path("/{EmployeeName}")
	public Employee updateEmployee(@PathParam("EmployeeName") String EmployeeName, Employee Employee){
		Employee.setLast_name(EmployeeName);
		return EmployeeService.updateEmployee(Employee);
	}
	 
	@GET
	@Path("empty")
	public void emptyDatabase() throws Exception{
		EmployeeService.emptyDatabase();
	}

	




}
