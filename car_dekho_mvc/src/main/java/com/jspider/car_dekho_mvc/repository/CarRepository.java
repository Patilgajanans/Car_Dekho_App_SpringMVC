package com.jspider.car_dekho_mvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspider.car_dekho_mvc.pojo.CarPOJO;

@Repository
public class CarRepository {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("Car");
		manager = factory.createEntityManager();
		transaction= manager.getTransaction();
	}
	
	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

	public CarPOJO addCar(String carName, String brandName, String fuelType, long price) {

		openConnection();
		transaction.begin();
		
		CarPOJO car = new CarPOJO();
		car.setModelName(carName.toUpperCase());
		car.setBrandName(brandName.toUpperCase());
		car.setPrice(price);
		car.setFuelType(fuelType.toUpperCase());
		manager.persist(car);
		transaction.commit();
		closeConnection();
		
		return car;
	}

	public List<CarPOJO> displayAllCars() {
		openConnection();
		transaction.begin();
		
		String jpql = "from CarPOJO";
		query = manager.createQuery(jpql);
		List<CarPOJO> cars = query.getResultList();
		
		transaction.commit();
		closeConnection();
		return cars;
	}

	public List<CarPOJO> searchCars(String attr, String value) {
		
		openConnection();
		transaction.begin();
		
		switch (attr) {
		case "id":
				{	
					query = manager.createQuery("select std from CarPOJO std where id = "
							+ value);
					
					break;
				}
		case "name":
				{
					query = manager.createQuery("select std from CarPOJO std where modelName = :n");
					query.setParameter("n", value.toUpperCase());
					break;
				}
		case "brand":
				{
					query = manager.createQuery("select std from CarPOJO std where brandName = :n");
					query.setParameter("n", value.toUpperCase());
					break;
				}
		case "fuel":
				{
					query = manager.createQuery("select std from CarPOJO std where fuelType = :n");
					query.setParameter("n", value.toUpperCase());
					break;
				}
				
		case "price":
				{
					query = manager.createQuery("select std from CarPOJO std where price = "+value);
					break;
				}
		default :{
			
			break;
		}
		}
		List<CarPOJO>cars=null;
		try {
			cars=query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		transaction.commit();
		closeConnection();
		
		return cars;
	}

	public CarPOJO editCar(int id, String name, long price, String fuel, String brand) {
		openConnection();
		transaction.begin();
		CarPOJO car = manager.find(CarPOJO.class, id);
		car.setBrandName(brand.toUpperCase());
		car.setModelName(name.toUpperCase());
		car.setFuelType(fuel.toUpperCase());
		car.setPrice(price);
		manager.persist(car);
		transaction.commit();
		closeConnection();
		return car;
	}

	public CarPOJO deleteCar(int id) {
		openConnection();
		transaction.begin();
		
		CarPOJO car = manager.find(CarPOJO.class, id);
		
		if (car != null) {
			manager.remove(car);
			transaction.commit();
		}
		closeConnection();
		return car;
	}

	
}
