package com.bloff.computerapp.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.bloff.computerapp.model.Computer;
import com.bloff.computerapp.repository.ComputerDao;

@Service
public class ComputerServiceImpl implements ComputerService {

	ComputerDao computerDao;
	
	public ComputerServiceImpl(ComputerDao computerDao) {
		this.computerDao = computerDao;
	}

	@Override
	public Map<Integer, Computer> getData() {
		return computerDao.getDbComputer();
	}

	@Override
	public Computer getData(Integer id) {
		return computerDao.getDbComputer().get(id);
	}

	@Override
	public Computer addData(Computer computer) {
		return computerDao.addComputer(computer);
	}

}
