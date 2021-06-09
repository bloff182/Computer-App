package com.bloff.computerapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Computer")
public class Computer {

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="ddr_type")
	private String ddrType;
	@Column(name="mhz")
	private Long mhz;
	@Column(name="memory_size")
	private Integer memorySize;

	public Computer() {
	}

	public Computer(String ddrType, Long mhz, Integer memorySize) {
		this.ddrType = ddrType;
		this.mhz = mhz;
		this.memorySize = memorySize;
	}

	public Computer(Long id, String ddrType, Long mhz, Integer memorySize) {
		this.id = id;
		this.ddrType = ddrType;
		this.mhz = mhz;
		this.memorySize = memorySize;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Computer [id=" + id + ", ddrType=" + ddrType + ", mhz=" + mhz + ", memorySize=" + memorySize + "]";
	}
	
	
	
	
}
