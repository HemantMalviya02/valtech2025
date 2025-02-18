package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArithmeticTest {
	private Arithmetic ari = new SimpleArithmetic();
	@Test
	void testAdd() {
		assertEquals(5.0, ari.add(3, 2));
	}

	@Test
	void testSub() {
		fail("Not yet implemented");
	}

	@Test
	void testMult() {
		fail("Not yet implemented");
	}

	@Test
	void testDivDoubleDouble() {
		fail("Not yet implemented");
	}

	@Test
	void testDivIntInt() {
		fail("Not yet implemented");
	}
	@Test
	void testDivWithIntDenumIsZero() {
		try {
			ari.div(3, 0);
			fail("Exception was Expected...");
			} catch(Exception e) {
				
			}
	}

}
