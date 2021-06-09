package com.bloff.computerapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloff.computerapp.model.Computer;
import com.bloff.computerapp.service.ComputerDbService;

@RestController
@RequestMapping("/api/db")
public class ControllerApiDB {

	private ComputerDbService computerService;
	
	public ControllerApiDB(ComputerDbService computerService) {
		this.computerService = computerService;
	}
	
	@GetMapping("/computers")
	public List<Computer> getData(){
		return computerService.getComputers();
	}
	
}
