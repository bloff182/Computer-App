package com.bloff.computerapp.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.bloff.computerapp.model.Computer;

@Repository
public class ComputerDao {

	private Map<Long, Computer> dbComputer = new TreeMap<>();
	
	private int dbSize = dbComputer.size();
	private List<Long> aviableDeletedId = new LinkedList<>();

	public ComputerDao(Map<Long, Computer> dbComputer) {
		this.dbComputer = dbComputer;
	}

	public Map<Long, Computer> getDbComputer() {
		return dbComputer;
	}

	public void setDbComputer(Map<Long, Computer> dbComputer) {
		this.dbComputer = dbComputer;
	}
	
	public int getDbSize() {
		return dbSize;
	}

	public void setDbSize(int dbSize) {
		this.dbSize = dbSize;
	}
	
	public List<Long> getAviableDeletedId() {
		return aviableDeletedId;
	}

	public void setAviableDeletedId(List<Long> aviableDeletedId) {
		
		this.aviableDeletedId = aviableDeletedId;
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
		
		if(aviableDeletedId.size() == 0){
				dbComputer.put(dbSize + 1L, computer);
				dbSize++;
		}
		else {
			dbComputer.put(aviableDeletedId.get(0), computer);
			aviableDeletedId.remove(0);
		}

		return computer;
	}
	
	
}
