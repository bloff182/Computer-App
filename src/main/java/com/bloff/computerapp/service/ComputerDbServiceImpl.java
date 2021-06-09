package com.bloff.computerapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bloff.computerapp.model.Computer;
import com.bloff.computerapp.repository.ComputerRepository;

@Service
public class ComputerDbServiceImpl implements ComputerDbService {

	private ComputerRepository computerRepo;
	
	public ComputerDbServiceImpl(ComputerRepository computerRepo) {
		this.computerRepo = computerRepo;
	}

	@Override
	public List<Computer> getComputers() {
		return computerRepo.findAll();
	}

}
