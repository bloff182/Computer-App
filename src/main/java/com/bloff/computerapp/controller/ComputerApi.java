package com.bloff.computerapp.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloff.computerapp.model.Computer;
import com.bloff.computerapp.service.ComputerService;

@RestController
@RequestMapping("/computers")
public class ComputerApi {

	ComputerService computerService;
	
	public ComputerApi(ComputerService computerService) {
		this.computerService = computerService;
		computerService.addData(new Computer("ddr1", 100L, 1000));
		computerService.addData(new Computer("ddr2", 200L, 2000));
	}

	@GetMapping("/get")
	public Map<Integer, Computer> getData(){
		
		return computerService.getData();
	}
	
	@GetMapping("/get/{id}")
	public Computer getById(@PathVariable Integer id) {
		
		return computerService.getData(id);
	}
	
	@PostMapping("/add")
	public Computer addData(@RequestBody Computer computer) {
		
		return computerService.addData(computer);
	}
	
	@GetMapping()
	public String hello() {
		return "hello";
	
	}
}
