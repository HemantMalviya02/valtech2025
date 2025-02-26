package spring.ioc;

public class PointFactory {
	static int i;
	public static Point createPoint() {
		return new Point(i++, i);
	}
}
