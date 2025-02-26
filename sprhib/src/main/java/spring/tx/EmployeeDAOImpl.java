package spring.tx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	static {
		try {
			Class.forName("org.postgresql.Driver");
		}catch(Exception e) {
			
		}
	}
	
	@Autowired
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
		
	
	private Connection getConnection() throws SQLException{
//		return DriverManager.getConnection
//				("jdbc:postgresql://localhost:5432/training","postgres","postgres");
		
		return dataSource.getConnection();
		
	}
	
	@Override
	public void save(Employee e) {
		
		new JdbcTemplate(dataSource).update("INSERT INTO EMPLOYEE (NAME, AGE, GENDER, SALARY, EXPERIENCE, LEVEL, ID) VALUES(?,?,?,?,?,?,?)",
				e.getName(), e.getAge(), e.getGender().name(), e.getSalary(), e.getExperience(), e.getLevel(), e.getId());
		
//		try(Connection con = getConnection()) {
//			PreparedStatement ps = con.prepareStatement
//					("INSERT INTO EMPLOYEE (NAME, AGE, GENDER, SALARY, EXPERIENCE, LEVEL, ID) VALUES(?,?,?,?,?,?,?)");
//			
//			setValuesToRequiredStatements(e, ps);
//			
//			int rowsAffected = ps.executeUpdate();
//			System.out.println("Rows Inserted = " + rowsAffected);
//			
//		}catch(Exception ex) {
//			throw new RuntimeException(ex);
//		}
	}

	private void setValuesToRequiredStatements(Employee e, PreparedStatement ps) throws SQLException {
		ps.setString(1, e.getName());
		ps.setInt(2, e.getAge());
		ps.setString(3, e.getGender().name());
		ps.setFloat(4, e.getSalary());
		ps.setInt(5, e.getExperience());
		ps.setInt(6, e.getLevel());
		ps.setLong(7, e.getId());
	}

	@Override
	public void update(Employee e) {
		
		new JdbcTemplate(dataSource).update("UPDATE EMPLOYEE SET NAME=?,AGE=?,GENDER=?,SALARY=?,EXPERIENCE=?,LEVEL=? WHERE ID=?",
				e.getName(), e.getAge(), e.getGender().name(), e.getSalary(), e.getExperience(), e.getLevel(), e.getId());
		
//		try(Connection con = getConnection()) {
//			PreparedStatement ps = con.prepareStatement
//					("UPDATE EMPLOYEE SET NAME=?,AGE=?,GENDER=?,SALARY=?,EXPERIENCE=?,LEVEL=? WHERE ID=?");
//			
//			setValuesToRequiredStatements(e, ps);
//			int rowsAffected = ps.executeUpdate();
//			System.out.println("Rows Updated = " + rowsAffected);
//			
//		}catch(Exception err) {
//			throw new RuntimeException(err);
//		}
	}

	@Override
	public void delete(int id) {
		
		new JdbcTemplate(dataSource).update("DELETE FROM EMPLOYEE WHERE ID = ?", id);
		
//			try(Connection con = getConnection()) {
//				PreparedStatement ps = con.prepareStatement
//						("DELETE FROM EMPLOYEE WHERE ID = ?");
//				ps.setInt(1, id);
//				int rowsAffected = ps.executeUpdate();
//				System.out.println("Rows Deleted = " + rowsAffected);
//				
//			}catch(Exception err) {
//				throw new RuntimeException(err);
//		}
	}

	@Override
	public Employee get(int id) {
		
		return new JdbcTemplate(dataSource)
				.queryForObject("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE WHERE ID = ?",
				new Object[] {id}, 
				new EmployeeRowMapper());
		
//		try(Connection con = getConnection()) {
//			PreparedStatement ps = con.prepareStatement
//					("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE WHERE ID = ?");
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//			
//			if(rs.next()) {
////				if next method returns true, we have another row, next return false we are at end of result
//				Employee e = populateEmployee(rs);
//				return e;
//			}else {
//				new RuntimeException("No Employee with id "+id+"Found.");
//			}
//			
//		}catch(Exception ex) {
//			throw new RuntimeException(ex);
//		}
//		return null;
	}
	
	
	private static class EmployeeRowMapper implements RowMapper<Employee> {

		@Override
		public Employee mapRow(ResultSet rs, int index) throws SQLException {
			
			return Employee.builder().id(rs.getInt(1)).name(rs.getString(2)).age(rs.getInt(3))
					.gender(Gender.valueOf(rs.getString(4))).salary(rs.getFloat(5)).experience(rs.getInt(6))
					.level(rs.getInt(7)).build();
		}
		
	}

//	public Employee populateEmployee(ResultSet rs) throws SQLException {
//		return Employee.builder().id(rs.getInt(1)).name(rs.getString(2)).age(rs.getInt(3))
//				.gender(Gender.valueOf(rs.getString(4))).salary(rs.getFloat(5)).experience(rs.getInt(6))
//						.level(rs.getInt(7)).build();
//	}
	@Override
	public List<Employee> getAll() {
		
		return new JdbcTemplate(dataSource).query("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE", 
				new EmployeeRowMapper());
//		List<Employee> emps = new ArrayList<Employee>();
//		try(Connection con = getConnection()) {
//			PreparedStatement ps = con.prepareStatement
//					("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE");
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				emps.add(populateEmployee(rs));
//			}
//		}catch(Exception ex) {
//			throw new RuntimeException(ex);
//		}
//		return emps;
	}

}
