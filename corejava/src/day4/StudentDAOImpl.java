package day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
	static {
		try {
			Class.forName( "org.postgres.Driver");
		}catch(Exception e) {
			
		}
	}
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("dbc:postgresql://localhost:5432/student\",\"postgres\",\"postgres");
	}
	@Override
	public void insert(Student s) {
		try(Connection con = getConnection()){
			PreparedStatement ps = con.prepareStatement("INSERT INTO STUDENT (rollNo, name, subject, percentage, gender) values(?,?,?,?,?)");
			
			setFunc(s,ps);
			
			int rowsAffected = ps.executeUpdate();
			System.out.println(rowsAffected);
			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	private void setFunc(Student s, PreparedStatement ps) throws SQLException{
		ps.setInt(1, s.getRollNo());
		ps.setString(2, s.getName());
		ps.setString(3, s.getSubject());
		ps.setFloat(4, s.getPercentage());
		ps.setString(5, s.getGender().name());
	}
	

	@Override
	public void delete(int id) {

	}

	@Override
	public void update(Student s) {

	}

	@Override
	public Student get(int id) {
		return null;
	}

	@Override
	public List<Student> getAll() {
		return null;
	}

}
