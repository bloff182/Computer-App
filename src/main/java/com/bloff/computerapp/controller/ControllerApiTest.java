package com.bloff.computerapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloff.computerapp.model.Computer;

@RestController
public class ControllerApiTest {

	List<Computer> list;
	
	public ControllerApiTest() {
		list = new ArrayList<>();
		list.add(new Computer("ddr2", 200L, 2000));
		list.add(new Computer("ddr3", 200L, 2000));
	}

	@GetMapping("/get")
	public List<Computer> getComputers(){
		return list;
	}
	

	@GetMapping("/test")
	public String hello() {
		return "hello new Controller";
	}
	
}
