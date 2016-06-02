package org.rbkpro.javacf.manager.database;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.rbkpro.javacf.manager.model.Employee;




public class FetchDatabase {
	private Connection connection ;
	private Database database;
	private static Map<String, Employee> employees=  new HashMap<>();
	private String DELETE_EMPLOYEES = "DELETE FROM employee";
	private String GET_EMPLOYEES = "SELECT * FROM employee ";
	private String ORDER_BY = "ORDER BY date_of_birth DESC";
	private String INSERT_EMPLOYEES ="insert into employee(first_name,last_name,date_of_birth,place_of_birth,marital_status,"
			+ "childs_number,phone_number,education_level,diploma,date_start_firstjob,grade_firstjob,date_join_cf,"
			+ "grade_join_cf,actual_grade) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public FetchDatabase(){
	    try {
	    	this.database= new Database();
			this.connection = database.Get_Connection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Map<String,Employee> getEmployees() throws Exception{
		employees.clear();
		try{
			PreparedStatement ps = connection.prepareStatement(GET_EMPLOYEES+ORDER_BY);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Employee employee = new Employee();
				employee.setFirst_name(rs.getString("first_name"));
				employee.setLast_name(rs.getString("last_name"));
				employee.setDate_of_birth(rs.getDate("date_of_birth"));
				employee.setPlace_of_birth(rs.getString("place_of_birth"));
				employee.setMarital_status(rs.getString("marital_status"));
				employee.setChilds_number(rs.getInt("childs_number"));
				employee.setPhone_number(rs.getString("phone_number"));
				employee.setEducation_level(rs.getString("education_level"));
				employee.setDiploma(rs.getString("diploma"));
				employee.setDate_start_firstjob(rs.getDate("date_start_firstjob"));
				employee.setGrade_firstjob(rs.getString("grade_firstjob"));
				employee.setDate_join_cf(rs.getDate("date_join_cf"));
				employee.setGrade_join_cf(rs.getString("grade_join_cf"));
				employee.setActual_grade(rs.getString("actual_grade"));
				
				employees.put(rs.getString("first_name")+rs.getRow(),employee);
				
			}
			return employees;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void emptyEmployees() throws SQLException{
		PreparedStatement ps = connection.prepareStatement(DELETE_EMPLOYEES);
		ps.executeUpdate();
	}
	
	public int insertEmployees() throws Exception{
		
		PreparedStatement ps = connection.prepareStatement(INSERT_EMPLOYEES);
		int nbr_employees=0;
		for(Employee em:getListEmployees()){
		Employee employee = em;
		ps.setString(1,employee.getFirst_name());
		ps.setString(2,employee.getLast_name());
		ps.setDate(3, new Date(employee.getDate_of_birth().getTime()));
		ps.setString(4,employee.getPlace_of_birth());
		ps.setString(5,employee.getMarital_status());
		ps.setInt(6,employee.getChilds_number());
		ps.setString(7,employee.getPhone_number());
		ps.setString(8,employee.getEducation_level());
		ps.setString(9,employee.getDiploma());
		ps.setDate(10,new Date(employee.getDate_start_firstjob().getTime()));
		ps.setString(11,employee.getGrade_firstjob());
		ps.setDate(12,new Date(employee.getDate_join_cf().getTime()));
		ps.setString(13,employee.getGrade_join_cf());
		ps.setString(14,employee.getActual_grade());
        int i = ps.executeUpdate();
        if(i>0)nbr_employees++;
		}
	    return nbr_employees;
	}
	
	public static List<Employee> getListEmployees() {
		Map<Long, Employee> employees=  new HashMap<>();

        try {
        	java.util.Date dt=new java.util.Date();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
             
        }
        catch (Exception e){
            System.err.print(e);
        }
        return new ArrayList<Employee>(employees.values());
    }

}

