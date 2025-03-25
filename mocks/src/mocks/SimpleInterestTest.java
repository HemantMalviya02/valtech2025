package mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class SimpleInterestTest {

	private SimpleInterestImpl si;
	private Arithmetic arith;
	
	@BeforeEach
	public void init() {
		si = new SimpleInterestImpl();
		arith = mock(Arithmetic.class);
		si.setArithmetic(arith);
	}
	
	@Test
	void test() {
		System.out.println(arith.getClass().getName());
		assertNotNull(arith);
		
		when(arith.mul(2000, 6)).thenReturn(12000);
		when(arith.mul(12000, 2)).thenReturn(24000);
		when(arith.div(24000, 100)).thenReturn(240);
		int res = si.compute(2000, 6, 2);
		assertEquals(res, 240);
		verify(arith).mul(2000, 6);
		si.compute(2000, 6, 2);
		verify(arith, atLeast(1)).mul(2000, 6);
	}

}
