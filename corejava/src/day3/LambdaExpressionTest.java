package day3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import day2.Car;

class LambdaExpressionTest {

	@Test
	void test() {
		List<Car> cars = new ArrayList<Car>();
		cars.add(Car.builder().make("Honda").model("City"). variant("ZX"). year(2024).
				version(7).build());
		cars.add(new Car("Benz","EClass","220D", 2024, 5));
		cars.add(Car.builder().make("Honda").model("City").variant("VX").year(2024).
				version(4).build());
		cars.add(Car.builder().make("Honda").model("Jazz").variant("ZX").year(2024).
				version(6).build());
		
		List<Car> newCars = new ArrayList<Car>();
		for(Car car : cars) {
			if(car.getVersion() > 5) {
				newCars.add(car);
			}
		}
		System.err.println(newCars);
		List<Car> myNewCars = cars.stream().filter(car->car.getVersion() > 5)
				.collect(Collectors.toList());
		System.out.println(myNewCars);
		
		System.out.println(cars.stream().filter(car->"Honda".equals(car.getMake())).
		collect(Collectors.toList()));
		
		
		System.out.println(cars.stream().map(car->car.getMake())
				.collect(Collectors.toSet()));
	}

}
