package day5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class EnhancedUtilsTest {

	@Test
	public void testMap() {
//		new method 
		Map<String, Integer> nums = Map.of("One", 1, "Two", 2, "Three", 3, "Four", 4);
		
	}
	
	@Test
	public void testList() {
		List<Integer> nums = List.of(1,2,3);
		try {
			nums.add(5);
			fail("Immutable List Expected");
		}catch(Exception e) {
//			e.printStackTrace();
		}
//		List<Integer>nums1 = new ArrayList<Integer>();    //convention way
	}
	@Test
	public void testMapsConventional() {
		Map<String,Integer> nums = new HashMap<String, Integer>();
		nums.put("One", 1);
		nums.put("Two", 2);
		nums.put("Three", 3);
	}
	@Test
	void testListConventional() {
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		System.out.println(nums);
		List<Integer> nums1 = Arrays.asList(1,2,3);
		assertEquals(nums, nums1);
	}

}
