package com.bloff.computerapp.service;

import java.util.Map;

import com.bloff.computerapp.model.Computer;

public interface ComputerService {

	public Map<Long, Computer> getData();

	public Computer getData(Long id);

	public Computer addData(Computer computer);

	public boolean deleteComputer(Long id);
	
	public Computer update(Computer newComputer, Long id);
}
