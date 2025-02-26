package day4;

import java.util.List;

public interface StudentDAO {
	public void insert(Student s);
	public void delete(int id);
	public void update(Student s);
	Student get(int id);
	List<Student> getAll();
}
