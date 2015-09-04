package org.rbkpro.javacf.messenger.resources;


import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.rbkpro.javacf.messenger.model.Employee;
import org.rbkpro.javacf.messenger.service.EmployeeService;

@Path("/employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {
	
	EmployeeService EmployeeService ; 
	
	public EmployeeResource() throws Exception{
		EmployeeService = new EmployeeService();
	}
	 
	@GET
	public ArrayList<Employee> getEmployees() {
		return EmployeeService.getAllEmployees();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("insertemployees")
	public String insertEmployee() throws Exception {	
		return "number employees inserted :"+EmployeeService.insertEmployees();
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
	
	@DELETE
	@Path("/{EmployeeName}")
	public void deleteEmployee(@PathParam("EmployeeName") String EmployeeName){
		EmployeeService.removeEmployee(EmployeeName);
	}

	




}
