package com.bloff.computerapp.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloff.computerapp.model.Computer;
import com.bloff.computerapp.service.ComputerService;

@RestController
@RequestMapping("/api")
public class ComputerApi {

	ComputerService computerService;
	
	public ComputerApi(ComputerService computerService) {
		this.computerService = computerService;
		computerService.addData(new Computer("ddr1", 100L, 1000));
		computerService.addData(new Computer("ddr2", 200L, 2000));
		computerService.addData(new Computer("ddr3", 200L, 2000));
		computerService.addData(new Computer("ddr4", 200L, 2000));
		computerService.addData(new Computer("ddr5", 200L, 2000));
	}

	@GetMapping("/computers")
	public Map<Long, Computer> getData(){
		
		return computerService.getData();
	}
	
	@GetMapping("/computers/{id}")
	public Computer getById(@PathVariable Long id) {
		
		return computerService.getData(id);
	}
	
	@PostMapping("/computers")
	public Computer addData(@RequestBody Computer computer) {
		
		return computerService.addData(computer);
	}
	
	@PutMapping("/computers/{id}")
	public Computer updateComputer(@RequestBody Computer newComputer, @PathVariable Long id) {
		
		return computerService.update(newComputer, id);
	}
	
	@DeleteMapping("computers/{id}")
	public boolean deleteComputer(@PathVariable Long id) {
		return computerService.deleteComputer(id);
	}
	
	@GetMapping()
	public String hello() {
		return "hello";
	
	}
}
