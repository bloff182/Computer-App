package com.bloff.computerapp.service;

import java.util.Map;
import java.util.Optional;

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
		
		Computer existComputer = computerDao.getDbComputer().get(id);
		if(existComputer == null) {
			throw new RuntimeException("Computer does not exist by id = " + id);
		} 
		
		return existComputer;
	}

	@Override
	public Computer addData(Computer computer) {
		return computerDao.addComputer(computer);
	}

	@Override
	public void deleteComputer(Integer id) {
		if (id == null) {
			throw new RuntimeException("Computer does not exist by id = " + id);
		}
		computerDao.getAviableDeletedId().add(id);
		computerDao.getDbComputer().remove(id);
		
	}

}
