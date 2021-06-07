package com.bloff.computerapp.service;

import java.util.Map;

import com.bloff.computerapp.model.Computer;

public interface ComputerService {

	public Map<Integer, Computer> getData();

	public Computer getData(Integer id);

	public Computer addData(Computer computer);

	public void deleteComputer(Integer id);
	
	
}
