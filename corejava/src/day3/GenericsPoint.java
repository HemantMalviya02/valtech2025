package day3;

public class GenericsPoint<T> {
	private T x;
	private T y;
	public GenericsPoint() {}
	public GenericsPoint(T x, T y) {
		this.x = x;
		this.y = y;
	}
	public T getX() {
		return x;
	}
	public void setX(T x) {
		this.x = x;
	}
	public T getY() {
		return y;
	}
	public void setY(T y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "GenericsPoint [x=" + x + ", y=" + y + "]";
	}
	
	
}
