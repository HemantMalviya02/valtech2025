package day5;

import day4.Gender;

public record EmployeeRecord(int id, String name, int age, Gender gender,
		float salary, int experience, int level) {
	
	public EmployeeRecord() {
		this(0,"",0,Gender.MALE,0,0,0);
	}
	
//	business method
	public int computeBonus() {
		return experience * 100 + level * 1000;
	}
}
