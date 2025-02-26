package day1;

public class Point3D extends Point {
	private double z;
	public Point3D() {}
	public Point3D(double x, double y, double z) {
		super(x,y);
		this.z = z;
	}
	@Override
	public double distance() {
		return super.distance();
	}
	
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	
	public double distance(point 3D)
	public double distance(double x, double y, double z) {
		double diffx = getX() - x;
		double diffy = getY() - y;
		double diffz = getZ() - z;
		
		return Math.sqrt(diffx * diffx + diffy*diffy + diffz*diffz);
	}
	
	@Override
	public double distance(double x1, double y1) {
		return Math.sqrt(getX() );
	}
}
