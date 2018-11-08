package net.rentalcars.service;

import java.math.BigDecimal;
import java.util.List;

import net.rentalcars.entity.Car;
import net.rentalcars.entity.Mark;

public interface ProductService {
	List<Car> listAllCars();

	List<Car> listAllCars(String accountType);

	void addCar(String mark, String title, BigDecimal price, int quality);

	void deleteCar(int id);

	void changeCar(String mark, String title, BigDecimal price, int quality, int id);

	void returnCar(int idCar);

	List<Mark> listAllMark();

	void addMark(String name);

	List<Car> listCarsByMark(String mark);
	
	List<Car> listCarsByQuality(int mark);
	
	List<Car> SortedListCars(String columnName);

}
