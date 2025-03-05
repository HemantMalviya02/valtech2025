package spring.ioc;

public class PointInstanceFactory {
	
	private int x;
	private int y;
	
	public PointInstanceFactory(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public Point createPoint(int x, int y) {
//		return new Point(this.x,this.y);   // will get values of pointInstanceFactory
//		return new Point(x,y);  // will take values of constructor
		return new Point(this.x+x, this.y+y);
	}
}
