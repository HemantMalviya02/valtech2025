package day4;

import java.util.Objects;

public class Student {
	private int rollNo;
	private String name;
	private String subject;
	private float percentage; 
	private Gender gender;
	
	
	public enum Gender{
		MALE, FEMALE;
	}
	public Student() {}
	
	public Student(int _rollNo, String _name, String _subject, float _per, Gender _gender) {
		this.rollNo = _rollNo;
		this.name = _name;
		this.subject = _subject;
		this.percentage = _per;
		this.gender = _gender;
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(gender, name, percentage, rollNo, subject);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return gender == other.gender && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(percentage) == Double.doubleToLongBits(other.percentage)
				&& rollNo == other.rollNo && Objects.equals(subject, other.subject);
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public static class StudentBuilder {
		private Student student;
		public StudentBuilder (Student _obj){
			student = _obj;
		}
		
		public Student build() {
			return student;
		}
		public StudentBuilder rollNo(int rollNo) {
			student.setRollNo(rollNo);
			return this;             // return immediate obj
		}
		public StudentBuilder name(String name) {
			student.setName(name);
			return this;             
		}
		public StudentBuilder subject(String subject) {
			student.setSubject(subject);
			return this;             
		}public StudentBuilder percentage(float percentage) {
			student.setPercentage(percentage);
			return this;             
		}
		public StudentBuilder gender(String gender) {
			student.setName(gender);
			return this;             
		}
	}
}
