package servlets;

public class Dept {
	private int id;
	private String name;
	private String location;
	
	public Dept() {}
	public Dept(int id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}
	
	public static DepartmentBuilder  builder() {
		return new DepartmentBuilder(new Dept());
	}
	
	
	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
//	Builder method
	public static class DepartmentBuilder {
		private Dept dept;
		public DepartmentBuilder(Dept _dept) {
			dept = _dept;
		}
		public Dept build() {
			return dept;
		}
		public DepartmentBuilder id(int _id) {
			dept.setId(_id);
			return this;
		}
		public DepartmentBuilder name(String _name) {
			dept.setName(_name);
			return this;
		}
		public DepartmentBuilder location(String _location) {
			dept.setLocation(_location);
			return this;
		}
	}
}
