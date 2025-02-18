package servlets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import dao.Employee;
import dao.Gender;
import jakarta.servlet.ServletContext;


public class DeptDAOImpl implements DeptDAO {
	
	private List<Dept> depts = new ArrayList<Dept>();
	
//	static {
//		try {
//			Class.forName("org.postgresql.Driver");
//		}catch(Exception e) {
//			
//		}
//	}
//	
	
	
//	Listener changes
	ServletContext sc;
	public DeptDAOImpl(ServletContext sc) {
		this.sc = sc;
	}
	
	
	private Connection getConnection(ServletContext sc) throws SQLException{
		String url = (String) sc.getAttribute("dbUrl");
		String username = (String) sc.getAttribute("dbUsername");
		String password = (String) sc.getAttribute("dbPass");
		return DriverManager.getConnection(url, username, password);
	}

	
//	 inserting
	
	@Override
	public void save(Dept dept) {
		try(Connection con = getConnection(this.sc)) {
			PreparedStatement ps = con.prepareStatement
					("INSERT INTO DEPARTMENT(NAME, LOCATION, ID) VALUES(?,?,?)");
			setValues(dept, ps);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Inserted = " + rowsAffected);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private void setValues(Dept d, PreparedStatement ps) throws SQLException{
		ps.setString(1, d.getName());
		ps.setString(2, d.getLocation());
		ps.setInt(3, d.getId());
	}
	
	
//	updating
	
	@Override
	public void update(Dept dept) {
		try(Connection con = getConnection(this.sc)) {
			PreparedStatement ps = con.prepareStatement
					("UPDATE EMPLOYEE SET NAME=?, LOCATION=?, WHERE ID=?");
			
			setValues(dept, ps);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Updated = " + rowsAffected);
			
		}catch(Exception err) {
			throw new RuntimeException(err);
		}
		
	}
	
//	Deleting
	
	@Override
	public void delete(int id) {
		try(Connection con = getConnection(this.sc)) {
			PreparedStatement ps = con.prepareStatement
					("DELETE FROM EMPLOYEE WHERE ID = ?");
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Deleted = " + rowsAffected);
			
		}catch(Exception err) {
			throw new RuntimeException(err);
		}
	}
	
	@Override
	public Dept getDept(int id) {
		try(Connection con = getConnection(this.sc)) {
			PreparedStatement ps = con.prepareStatement
					("SELECT ID,NAME,LOCATION FROM DEPARTMENT WHERE ID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Dept d = populateDept(rs);
				return d;
			}else {
				new RuntimeException("No Department with id "+id+"Found.");
			}
		}  catch(Exception e) {
			
		}
		return null;
	}
	
		
	@Override 
	public List<Employee> setDept(int id) {
		List<Employee>employee = new ArrayList<Employee>();
		try(Connection con = getConnection(this.sc)) {
			PreparedStatement ps = con.prepareStatement
					("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,DEPT_ID FROM EMPLOYEE WHERE dept_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				employee.add(populateEmployee(rs));
			}
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
//		System.out.println("Employee"+employee);
		return employee;
	}
	public Dept populateDept(ResultSet rs) throws SQLException {
		return Dept.builder()
				.id(rs.getInt(1))
				.name(rs.getString(2))
				.location(rs.getString(3))
				.build();
	}
	
	public Employee populateEmployee(ResultSet rs) throws SQLException {
		return Employee.builder().id(rs.getInt(1)).name(rs.getString(2)).age(rs.getInt(3))
				.gender(dao.Gender.valueOf(rs.getString(4))).salary(rs.getFloat(5)).experience(rs.getInt(6))
						.level(rs.getInt(7)).deptId(rs.getInt(8)).build();
	}
	
	
	@Override
	public Dept first() {
		depts = getAll();
		return depts.stream().min(Comparator.comparingInt(Dept::getId)).orElse(null);
//		return depts.get(depts.keySet().stream().min((a,b) -> (a - b)).get());
	}

	@Override
	public Dept last() {
		return depts.stream().max(Comparator.comparingInt(Dept::getId)).orElse(null);
	}

	@Override
	public Dept next(int id) {
		depts = getAll();
		if(id == depts.size()) 
				return getDept(id);
		return getDept(id+1);
		
		
//		return depts.stream()						 //Converts the List<Dept> into a stream.
//		        .filter(dept -> dept.getId() > id)  // This keeps only the departments where the ID is greater than the given id.
//		        								   	//: If id = 3, and we have IDs {1, 3, 5, 7}, it filters {5, 7}.
//		        .min(Comparator.comparingInt(Dept::getId)) // Finds the department with the smallest ID from the remaining ones.
//		        								    //From {5, 7}, the smallest is 5.
//		        .orElse(null); 						// if there’s no next department, return null.
	}

	@Override
	public Dept previous(int id) {
		depts = getAll();
		if(id == 1)
				return getDept(id);
		return getDept(id-1);
	}


	@Override
	public List<Dept> getAll() {
		List<Dept> department = new ArrayList<Dept>(); 
		try(Connection con = getConnection(this.sc)) {
			PreparedStatement ps = con.prepareStatement
					("SELECT ID,NAME,LOCATION FROM DEPARTMENT");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				department.add(populateDept(rs));
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		return department;
	}


	}


	




//public class DeptDAOImpl implements DeptDAO {

//	private Map<Integer,Dept> depts;
//	
//	public DeptDAOImpl() {
//		depts = new HashMap<Integer, Dept>();
//	}
//	@Override
//	public void save(Dept dept) {
//		depts.put(dept.getId(), dept);
//	}
//	
//	@Override
//	public void update(Dept dept) {
//		depts.put(dept.getId(), dept);
//	}
//	
//	@Override
//	public Dept getDept(int id) {
//		return depts.get(id);
//	}
//	
//	@Override
//	public void delete(int id) {
//		depts.remove(id);
//	}
//	
//	@Override
//	public Set<Dept> getAll() {
//		Set<Dept> all = new HashSet<Dept>();
//		for(int id : depts.keySet()) {
//			all.add(depts.get(id));
//		}
//		return all;
//	}
//
//	@Override
//	public Dept first() {
//		return depts.get(depts.keySet().stream().min((a,b) -> (a - b)).get());
//	}
//
//	@Override
//	public Dept last() {
//		return depts.get(depts.keySet().stream().max((a,b) -> (a - b)).get());        // or min(b-a)
//	}
//
//	@Override
//	public Dept next(int id) {
//		if(id == depts.size())
//				return depts.get(depts.size());
//		return depts.get(id+1);
//	}
//
//	@Override
//	public Dept previous(int id) {
//		if(id == 1) 
//				return getDept(1);
//		return depts.get(id-1);
//	}
//}
