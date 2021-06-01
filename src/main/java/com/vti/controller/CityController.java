package com.vti.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.City;
import com.vti.service.ICityService;

@RestController
@RequestMapping(value = "api/v1/cities")
@CrossOrigin("*")
public class CityController {
	@Autowired
	private ICityService service;
	
	/**
	 * Get all city
	 * 
	 * @Description: Has a search function
	 * @author: Đặng Văn Hải
	 * @create_date: 23/5
	 * @version: 1
	 * @modifer: 
	 * @modifer_date: 
	 * @return : List City information
	 */	
	@GetMapping
	public ResponseEntity<?> getAllCities(String search){	
		List<City> entities = service.getAllCities(search);	
		return new ResponseEntity<List<City>>(entities,HttpStatus.OK);
	}

	
	@GetMapping(value = "name/{name}")
	public ResponseEntity<?> getCityByName(@PathVariable(name = "name") String name) {
		return new ResponseEntity<City>(service.getCityByName(name), HttpStatus.OK);
	}
	
	
	@GetMapping(value = "id/{id}")
	public ResponseEntity<?> getCityById(@PathVariable(name = "id") int id) {
		return new ResponseEntity<City>(service.getCityById(id), HttpStatus.OK);
	}
	

}
