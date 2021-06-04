package com.bloff.computerapp.repository;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.bloff.computerapp.model.Computer;

@Repository
public class ComputerDao {

	private Map<Integer, Computer> dbComputer = new TreeMap<>();

	public ComputerDao(Map<Integer, Computer> dbComputer) {
		this.dbComputer = dbComputer;
	}

	public Map<Integer, Computer> getDbComputer() {
		return dbComputer;
	}

	public void setDbComputer(Map<Integer, Computer> dbComputer) {
		this.dbComputer = dbComputer;
	}
	
	public Computer addComputer(Computer computer) {
		
		if (computer.getDdrType()==null || computer.getDdrType()=="") {
			throw new RuntimeException("ddr type field can not be empty");
		}
		if (computer.getMemorySize()<=0) {
			throw new RuntimeException("Memory size must be greather than zero");
		}
		if (computer.getMhz()<=0) {
			throw new RuntimeException("mhz must be greather than zero");
		}
		
		int dbComputerSize = dbComputer.size();
		
		dbComputer.put(dbComputerSize + 1, computer);
		
		return computer;
	}
	
	
}
