package day4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeDAOTest {

	@Test
	void testInsert() {
		EmployeeDAO dao = new EmployeeDAOimpl();
//		dao.save(new Employee(2, "Working", 25, 15000, Gender.FEMALE, 6,3));
		Employee e = new Employee(1,"DEF",23,12500,Gender.MALE,5,2);
		dao.update(e);
		e = dao.get(1);
//		assertEquals(1,e.getId());
//		assertEquals("DEF",e.getName());
//		assertEquals(23,e.getAge());
//		assertEquals(Gender.MALE,e.getGender());
//		assertEquals(12500,e.getSalary());
//		assertEquals(2,e.getExperience());
//		assertEquals(5,e.getLevel());
		
//		assertTrue(dao.getAll().size() > 1);
		dao.delete(1);
	}

}
