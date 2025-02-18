package day4;

import org.junit.Test;

import junit.framework.TestCase;

public class StudentDAOTest extends TestCase {
	@Test
	void testInsert() {
		StudentDAO st = new StudentDAOImpl();
		
		st.insert(new Student(1, "Sakshi", "Maths", 92.0, Gender.FEMALE));
	}
}
