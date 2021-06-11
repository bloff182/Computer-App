package com.bloff.computerapp.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bloff.computerapp.exception.ComputerNotFoundException;
import com.bloff.computerapp.model.Computer;
import com.bloff.computerapp.repository.ComputerDao;

@Service
public class ComputerServiceImpl implements ComputerService {

	ComputerDao computerDao;

	public ComputerServiceImpl(ComputerDao computerDao) {
		this.computerDao = computerDao;
	}

	@Override
	public Map<Long, Computer> getData() {
		return computerDao.getDbComputer();
	}

	@Override
	public Computer getData(Long id) {

		Computer existComputer = computerDao.getDbComputer().get(id);
		if (existComputer == null) {
			throw new ComputerNotFoundException(id);
		}

		return existComputer;
	}

	@Override
	public Computer addData(Computer computer) {
		return computerDao.addComputer(computer);
	}

	@Override
	public boolean deleteComputer(Long id) {
		if (computerDao.getDbComputer().get(id) == null) {
//			throw new ComputerNotFoundException(id)
			return false;
		}
		computerDao.getAviableDeletedId().add(id);
		computerDao.getDbComputer().remove(id);
		return true;
	}

	@Override
	public Computer update(Computer newComputer, Long id) {
		Computer updatedComputer = computerDao.getDbComputer().get(id);

		if (updatedComputer == null) {
			return newComputer;
		} else {
			updatedComputer.setDdrType(newComputer.getDdrType());
			updatedComputer.setMhz(newComputer.getMhz());
			updatedComputer.setMemorySize(newComputer.getMemorySize());

			return updatedComputer;
		}
	}
}
