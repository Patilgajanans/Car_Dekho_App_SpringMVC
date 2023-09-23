package com.jspider.car_dekho_mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspider.car_dekho_mvc.pojo.CarPOJO;
import com.jspider.car_dekho_mvc.pojo.UserPOJO;
import com.jspider.car_dekho_mvc.service.CarService;

@Controller
public class CarController {
	
	@Autowired
	private CarService service;
	
	@GetMapping("/home")
	public String home(@SessionAttribute(name="login",required = false) UserPOJO pojo,ModelMap map ) {
		if (pojo != null) {
			return "Home";
		}
		map.addAttribute("msg","Session Ended ! Login to procced...");
		return "Login";
	}
	
	@GetMapping("/add")
	public String AddCar(@SessionAttribute(name="login",required = false) UserPOJO pojo,ModelMap map) {
		if (pojo != null) {
			List<CarPOJO>cars = service.displayAllCars();
			map.addAttribute("cars" , cars);
			return "Add";
		}
		map.addAttribute("msg","Session Ended ! Login to procced...");
		return "Login";
	}
	
	@GetMapping("/search")
	public String search(@SessionAttribute(name="login",required = false) UserPOJO pojo,ModelMap map) {
		if (pojo != null) {
			return "Search";
		}
		map.addAttribute("msg","Session Ended ! Login to procced...");
		return "Login";
	}
	
	@GetMapping("/delete")
	public String delete(@SessionAttribute(name="login",required = false) UserPOJO pojo,ModelMap map) {
		if (pojo != null) {
			List<CarPOJO>cars=service.displayAllCars();
			map.addAttribute("cars",cars);
			return "Delete";
		}
		map.addAttribute("msg","Session Ended ! Login to procced...");
		return "Login";
	}
	
	@GetMapping("/update")
	public String update(@SessionAttribute(name="login",required = false) UserPOJO pojo,ModelMap map) {
		if (pojo != null) {
			return "Update";
		}
		map.addAttribute("msg","Session Ended ! Login to procced...");
		return "Login";
	}
	
	
	@PostMapping("/add")
	public String addCar(@RequestParam String carName, @RequestParam String brandName, @RequestParam String fuelType, @RequestParam long price,@SessionAttribute(name="login",required = false) UserPOJO pojo,ModelMap map) {
		
		if (pojo != null) {
			CarPOJO car = null;
			List<CarPOJO>cars = null;
			if (!carName.isEmpty() && !brandName.isEmpty() && !(price < 0)) {
				car = service.addCar(carName,brandName,fuelType,price);
					}
			if (car != null) {
				cars = service.displayAllCars();
				map.addAttribute("cars" , cars);
				map.addAttribute("msg","Car Added Successfully !");
				return "Add";
			}
			cars = service.displayAllCars();
			map.addAttribute("cars" , cars);
			map.addAttribute("msg","Car Not Added !");
			return "Add";
		}
		map.addAttribute("msg","Session Ended ! Login to procced...");
		return "Login";
		
	}
	
	@PostMapping("/search")
	public String search(@RequestParam String selectedOption, @RequestParam String value, @SessionAttribute(name="login",required = false) UserPOJO pojo,ModelMap map) {
		
		if (pojo != null) {
			List<CarPOJO> cars = null;
			if (selectedOption.equals("All")) {
				cars= service.displayAllCars();
			}
			else {
				cars = service.searchCars(selectedOption,value);
			}
		
			if (cars != null) {
				if (!cars.isEmpty()) {
					map.addAttribute("cars" , cars);
					map.addAttribute("msg","Data Found successfully  !");
					return "Search";
				}
			}
			
			map.addAttribute("cars" , cars);
			map.addAttribute("msg","Data not Found");
			return "Search";
		}
		map.addAttribute("msg","Session Ended ! Login to procced...");
		return "Login";
	}
	
	@PostMapping("/update")
	public String update(@RequestParam String selectedOption, @RequestParam String value, @SessionAttribute(name="login",required = false) UserPOJO pojo,ModelMap map) {
		
		if (pojo!= null) {
			List<CarPOJO> cars = null;
			if (selectedOption.equals("All")) {
				cars= service.displayAllCars();
			}
			else {
				cars = service.searchCars(selectedOption,value);
			}
		
			if (cars != null) {
				if (!cars.isEmpty()) {
					map.addAttribute("cars" , cars);
					map.addAttribute("msg","Data Found successfully  !");
					return "Update";
				}
			}
			
			map.addAttribute("cars" , cars);
			map.addAttribute("msg","Data not Found");
			return "Update";
		}
		map.addAttribute("msg","Session Ended ! Login to procced...");
		return "Login";
	}
	
	@PostMapping("/save")
	public String saveDetails(@RequestParam int []id,@RequestParam String []name,@RequestParam long []price,@RequestParam String []fuel,@RequestParam String []brand,@SessionAttribute(name="login",required = false) UserPOJO pojo,ModelMap map)
	{
		
			if (pojo != null) {
				List<CarPOJO>cars = new ArrayList<CarPOJO>();
				int num=0;
				for(int id2 : id) {
					cars.add(service.editCar(id[num], name[num], price[num],fuel[num], brand[num]));
					num++;
				}
				
				if (!cars.isEmpty()) {
					map.addAttribute("msg","Details Saved Successfully......!");
					map.addAttribute("cars",cars);
					return "Update" ;
					
				}
				map.addAttribute("msg", "Details Is Not Saved ....!");
				return "Update";
		
			}
			map.addAttribute("msg","Session Ended ! Login to procced...");
			return "Login";
	}
	
	@PostMapping ("/delete")
	public String delete(@RequestParam int id,@SessionAttribute(name="login",required = false) UserPOJO pojo,ModelMap map) {
		if (pojo != null) {
			CarPOJO car = service.deleteCar(id);
			List<CarPOJO> cars = service.displayAllCars();
			if (car != null) {
				
				map.addAttribute("msg" ,"Data Removed Successfully");
				map.addAttribute("cars",cars);
				return "Delete";
			}
			map.addAttribute("msg" ,"Data Not Removed ");
			map.addAttribute("cars",cars);
			return "Delete";
		}
		map.addAttribute("msg","Session Ended ! Login to procced...");
		return "Login";
	}

}
