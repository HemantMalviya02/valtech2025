package spring.tx;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

//import day4.Gender;

@Entity
public class Employee implements Comparable<Employee>{
	
	@Id
	private long id;
	private String name;
	private int age;
	private float salary;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private int level;
	private int experience;
	
	public Employee(long _id, String _name, int _age, float _salary, Gender _gender,
			int _level, int _experience) {
		id = _id;
		name = _name;
		age = _age;
		salary = _salary;
		gender = _gender;
		level = _level;
		experience = _experience;
	}
	
	
	public static EmployeeBuilder builder() {
		return new EmployeeBuilder(new Employee());
	}
	
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	

	@Override
	public String toString(){
//		return make+" "+model+" "+Variant+" "+year+" "+version;
		return new StringBuilder()
				.append(id)
				.append(" ")
				.append(name)
				.append(" ")
				.append(age)
				.append(" ")
				.append(salary)
				.append(" ")
				.append(gender)
				.append(" ")
				.append(level)
				.append(" ")
				.append(experience)
				.toString();		
	}


@Override
	public int hashCode() {
		return Objects.hash(age, experience, gender, id, level, name, salary);
	}

//comparable

@Override
public int compareTo(Employee o) {
	int compLevel = Integer.compare(this.level, o.level);
	if(compLevel != 0)
		return compLevel;
	
	int compExp = Integer.compare(this.experience, o.experience);
	if (compExp != 0)
			return compExp;
	
	int compGender = this.gender.compareTo(o.gender);
	if(compGender != 0)
			return compGender;
	
//	int compSalary = Float.compare(this.salary, o.salary);
//	if(compSalary != 0) 
//			return compSalary;
	
	return Float.compare(this.salary, o.salary);
 }
//comparator

//public static Comparator<Employee>byLevel() {
//	return(Employee emp1, Employee emp2) -> Integer.compare(emp1.level, emp2.level);
//}
//public static Comparator<Employee>byExperience() {
//	return(Employee emp1, Employee emp2) -> Integer.compare(emp1.experience, emp2.experience);
//}
//public static Comparator<Employee>byGender() {
//	return(Employee emp1, Employee emp2) -> emp1.getGender().compareTo(emp2.getGender());
//}
//public static Comparator<Employee>bySalary() {
//	return(Employee emp1, Employee emp2) -> Float.compare(emp1.getSalary(), emp2.getSalary());
//}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return age == other.age && experience == other.experience && gender == other.gender && id == other.id
				&& level == other.level && Objects.equals(name, other.name)
				&& Float.floatToIntBits(salary) == Float.floatToIntBits(other.salary);
	}


	//	default ctor
	public Employee() {
		
	}
	
	
	public static class EmployeeBuilder {
		
		private Employee emp;
		public EmployeeBuilder(Employee _emp) {
			emp = _emp;
		}
		public Employee build() {
			return emp;
		}
		public EmployeeBuilder id(int id) {
			emp.setId(id);
			return this;
		}
		public EmployeeBuilder name(String name) {
			emp.setName(name);
			return this;
		}
		public EmployeeBuilder age(int age) {
			emp.setAge(age);
			return this;
		}
		public EmployeeBuilder salary(float salary) {
			emp.setSalary(salary);
			return this;
		}
		public EmployeeBuilder level(int level) {
			emp.setLevel(level);
			return this;
		}
		public EmployeeBuilder experience(int experience) {
			emp.setExperience(experience);
			return this;
		}
		public EmployeeBuilder gender(Gender gender) {
			emp.setGender(gender);
			return this;
		}
	}

}
