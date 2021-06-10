package com.bloff.computerapp.model;

import java.time.LocalDate;

import javax.persistence.Column;

public class ComputerDto {

	private String ddrType;
	private Long mhz;
	private Integer memorySize;
	private LocalDate localDate;
	private String name;
	
	public ComputerDto() {}
	
	public ComputerDto(String ddrType, Long mhz, Integer memorySize, LocalDate localDate) {
		this.ddrType = ddrType;
		this.mhz = mhz;
		this.memorySize = memorySize;
		this.localDate = localDate;
	}

	public String getDdrType() {
		return ddrType;
	}

	public void setDdrType(String ddrType) {
		this.ddrType = ddrType;
	}

	public Long getMhz() {
		return mhz;
	}

	public void setMhz(Long mhz) {
		this.mhz = mhz;
	}

	public Integer getMemorySize() {
		return memorySize;
	}

	public void setMemorySize(Integer memorySize) {
		this.memorySize = memorySize;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("ComputerDto [ddrType= %s, mhz= %s, memorySize=%s ]",ddrType,mhz,memorySize);
	}
	
	
	
}
