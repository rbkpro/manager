package org.rbkpro.javacf.messenger.database;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.rbkpro.javacf.messenger.model.Employee;




public class FetchDatabase {
	private Connection connection ;
	private Database database;
	private static Map<String, Employee> employees=  new HashMap<>();
	private String GET_EMPLOYEES= "SELECT * FROM employee ";
	private String ORDER_BY = "ORDER BY date_of_birth DESC";
	private String INSERT_EMPLOYEES="insert into employee(first_name,last_name,date_of_birth,place_of_birth,marital_status,"
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
				employee.setGrade_firstjob(rs.getString("grade_join_cf"));
				employee.setGrade_firstjob(rs.getString("actual_grade"));
				
				employees.put(rs.getString("first_name")+rs.getRow(),employee);
				
			}
			return employees;
		}
		catch(Exception e)
		{
			throw e;
		}
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
            employees.put(1L, new Employee("فراح", "زيموش", df.parse("19/07/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(2L, new Employee("نبيل", "ناصر", df.parse("19/07/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(3L, new Employee("سهام", "بوحوحو", df.parse("19/07/2015"),null,null,0,null,null,null,dt,null,dt,null,null));

            employees.put(4L, new Employee("حياة", "بن خليفة", df.parse("26/07/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(5L, new Employee("صالح", "رماش", df.parse("26/07/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(6L, new Employee("أمين", "سطاح", df.parse("26/07/2015"),null,null,0,null,null,null,dt,null,dt,null,null));

            employees.put(7L, new Employee("يزيد", "خلاف", df.parse("02/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(8L, new Employee("عبد الهادي", "بلفتحي", df.parse("02/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(9L, new Employee("سلمى", "معروف", df.parse("02/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(10L, new Employee("سليمة", "فرعيشي", df.parse("02/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(11L, new Employee("احمد", "بلخطابية", df.parse("02/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(12L, new Employee("فضيلة", "بولعيد", df.parse("02/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(13L, new Employee("رضوان", "عميمور", df.parse("02/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(14L, new Employee("حورية", "عزيز", df.parse("02/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(15L, new Employee("احمد", "عاشور", df.parse("02/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));

            employees.put(16L, new Employee("عماد", "شلية", df.parse("05/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));

            employees.put(17L, new Employee("نوال", "بن شاشم", df.parse("09/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(18L, new Employee("نوارة", "بلكامل", df.parse("09/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(19L, new Employee("عماد", "خميسي", df.parse("09/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(20L, new Employee("لخضر", "أمقران", df.parse("09/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(21L, new Employee("فريدة", "بن لخضر", df.parse("09/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(22L, new Employee("حنان", "بزاز", df.parse("09/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(23L, new Employee("أسماء", "بودن", df.parse("09/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));

            employees.put(24L, new Employee("هشام", "زردود", df.parse("16/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));

            employees.put(25L, new Employee("اسماعيل", "فنوش", df.parse("23/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(26L, new Employee("الزبير", "خليفة", df.parse("23/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(27L, new Employee("شعيب", "بوحالة", df.parse("23/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(28L, new Employee("رابح", "عوقابة", df.parse("23/08/2015"),"chigara","carte jaune",0,"05 60 83 53 46","universitaire","master",df.parse("23/05/2013"),"ingénieur",df.parse("23/05/2013"),"ingénieur","ingénieur"));

            employees.put(29L, new Employee("رحيمة", "بريك", df.parse("26/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(30L, new Employee("أميرة", "بلقدري", df.parse("30/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(31L, new Employee("عبد المؤمن", "علام", df.parse("01/09/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(32L, new Employee("محمد", "صايفي", df.parse("06/09/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(33L, new Employee("فتيحة", "مسيلي", df.parse("06/09/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(34L, new Employee("حمزة", "لمزري", df.parse("13/09/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(35L, new Employee("نسيمة", "بولحليب", df.parse("27/09/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(36L, new Employee("سمير", "نحال", df.parse("04/10/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(37L, new Employee("زهور", "بودن", df.parse("04/10/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(38L, new Employee("سارة", "صدراتي", df.parse("02/11/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(39L, new Employee("طارق", "عميرة", df.parse("15/11/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(40L, new Employee("نصيرة", "بوسنة", df.parse("29/11/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
            employees.put(41L, new Employee("منال", "ناصري", df.parse("01/12/2015"),null,null,0,null,null,null,dt,null,dt,null,null));

            employees.put(42L,new Employee("زكية", "بوعبدالله", df.parse("23/08/2015"),null,null,0,null,null,null,dt,null,dt,null,null));
        }
        catch (Exception e){
            System.err.print(e);
        }

        return new ArrayList<Employee>(employees.values());
    }
	
	/*
	public employee getEmployee(String employeeName) throws Exception{
		employee employee=new employee();
		try
		{
			PreparedStatement ps = connection.prepareStatement(GET_EMPLOYEES+"WHERE first_name = ?");
			ps.setString(1, employeeName);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				employee.setId(rs.getLong("_id"));
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setemployeeName(rs.getDate("date_of_birth").toString());
				
			}
			return employee;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
*/

}

