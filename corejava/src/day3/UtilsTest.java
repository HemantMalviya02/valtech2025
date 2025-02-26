package day3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

class UtilsTest {

	public class Point implements Comparable<Point>{
		
		private int x;
		private int y;
		
		
		public Point () {}
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(x, y);
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return x == other.x && y == other.y;
		}


		public Point (int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Point other) {
//			if content is equal then return 0 coz same
			if(this == other || this.equals(other))
				return 0;
			
						
			int diffX = x - other.x;
			if(diffX == 0)
				return y - other.y;
			
				return diffX;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}


		private UtilsTest getEnclosingInstance() {
			return UtilsTest.this;
		}
		
	}
	
	
	
	@Test 
	public void testHashMaps() {
		tryingMaps(new HashMap<String, Integer>());
	}
	
	@Test 
	public void testTreeMaps() {
		tryingMaps(new TreeMap<String, Integer>());
	}
	
	
	public void tryingMaps(Map<String, Integer> numbers) {
		assertEquals(0, numbers.size());
		numbers.put("One", 1);
		assertEquals(1, numbers.size());
		assertEquals(1, numbers.get("One"));
		
		numbers.put("One", 2);
		assertEquals(1, numbers.size());
		assertEquals(2, numbers.get("One"));
		
//		Lowercase so size will change means new key created
		numbers.put("one", 1);
		assertEquals(2, numbers.size());
		assertEquals(1, numbers.get("one"));
		
	}
	
	@Test
	public void testArraylist() {
		tryingLists(new ArrayList<UtilsTest.Point>());
	}
	
	@Test
	public void testLinkedlist() {
		tryingLists(new LinkedList<UtilsTest.Point>());
	}
	
	public void tryingLists(List<Point> points) {
		assertEquals(0, points.size());
		Point p = new Point(2,3);
		points.add(p);
		assertEquals(1, points.size());
		points.add(p);
		assertEquals(2, points.size());
		points.add(new Point(2,3));
		assertEquals(3, points.size());
		points.add(new Point(3,2));
		assertEquals(4, points.size());
	}
	
	
	public void tryingSets(Set<Point> points) {
		assertEquals(0, points.size());
		Point p = new Point(2,3);
		points.add(p);
		assertEquals(1, points.size());
		points.add(p);
		assertEquals(1, points.size());
//		now adding one more key, but it has same content so no chance in value.
		points.add(new Point(2,3));
		assertEquals(1, points.size());
//		adding new key with different key, so the value becomes 2 coz of different keys
		points.add(new Point(3,2));
		assertEquals(2, points.size());
	}
	
	
	@Test
	public void testHashSet() {
		tryingSets(new HashSet<UtilsTest.Point>());
	}
	
	@Test
	public void testTreeSet() {
		tryingSets(new TreeSet<UtilsTest.Point>());
	}
}
