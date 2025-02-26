package spring.ioc;

public class Line {
	private Point start;
	private Point end;
	
	public Line() {}
	
	
	public Line(Point start, Point end) {
		super();
		this.start = start;
		this.end = end;
	}


	
	@Override
	public String toString() {
		return "Line [start=" + start + ", end=" + end + "]";
	}


	public Point getStart() {
		return start;
	}
	public void setStart(Point start) {
		this.start = start;
	}
	public Point getEnd() {
		return end;
	}
	public void setEnd(Point end) {
		this.end = end;
	}
	
	
}
