package day4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SquareTest {

	@Test

	void testSquare() {
		Square square = (a) -> a*a;
		assertEquals(0,square.squareNow(0));
		assertEquals(0,square.squareNow(-0));
		assertEquals(1,square.squareNow(1));
		assertEquals(1,square.squareNow(-1));
	}

}
