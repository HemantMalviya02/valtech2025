package day1;

public class Dog implements Animal {

	@Override
	public void makeSound() {
		System.out.println("Bark...");

	}

	@Override
	public void eat() {
		System.out.println("Eat Pedigree...");

	}

	@Override
	public void sleep() {
		System.out.println("Snore...");

	}

}
