package com.jspider.car_dekho_mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.car_dekho_mvc.pojo.CarPOJO;
import com.jspider.car_dekho_mvc.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository repository;

	public CarPOJO addCar(String carName, String brandName, String fuelType, long price) {
		CarPOJO car = repository.addCar(carName,brandName,fuelType,price);
		return car;
	}

	public List<CarPOJO> displayAllCars() {
		List<CarPOJO>cars = repository.displayAllCars();
		return cars;
	}

	public List<CarPOJO> searchCars(String attr, String value) {
		List<CarPOJO> cars = repository.searchCars(attr, value);
		return cars;
	}

	public CarPOJO editCar(int id, String name, long price, String fuel, String brand) {
		CarPOJO car =  repository.editCar(id, name, price,fuel, brand);
		return car;
	}

	public CarPOJO deleteCar(int id) {
		CarPOJO car = repository.deleteCar(id);
		return car;
	}
	
}
