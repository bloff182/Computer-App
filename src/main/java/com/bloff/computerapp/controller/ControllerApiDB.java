package com.bloff.computerapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloff.computerapp.model.Computer;
import com.bloff.computerapp.model.ComputerDto;
import com.bloff.computerapp.service.ComputerDbService;

@RestController
@RequestMapping("/api/db")
public class ControllerApiDB {

	private ComputerDbService computerService;
	private List<ComputerDto> localDB;
	ModelMapper modelMapper = new ModelMapper();

	@Autowired
	public ControllerApiDB(ComputerDbService computerService) {
		this.computerService = computerService;
		this.localDB = new ArrayList<>();
	}

	@GetMapping("/computers")
	public List<ComputerDto> getData() {

		List<Computer> computers = computerService.getComputers();
		for (Computer dtoComputer : computers) {
			localDB.add(modelMapper.map(dtoComputer, ComputerDto.class));
		}
			
		return localDB;
	}


}
