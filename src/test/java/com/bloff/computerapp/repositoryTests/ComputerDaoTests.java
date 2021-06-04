package com.bloff.computerapp.repositoryTests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bloff.computerapp.model.Computer;
import com.bloff.computerapp.repository.ComputerDao;

public class ComputerDaoTests {

	private Map<Integer, Computer> tempDB = new TreeMap<>();
	
	private ComputerDao repo;

	@BeforeEach
	public void setUp() {
		
		repo = new ComputerDao(tempDB);
	}
	
	@Test
	public void should_add_new_computer() {
		Computer comp = new Computer("ddr1",10L,2000);
		
		Computer savedComputer = repo.addComputer(comp);
		
		assertThat(tempDB.size()).isEqualTo(1);
		assertThat(savedComputer).isEqualTo(comp);
	}
	
	@Test
	public void should_not_add_new_computer_with_wrong_ddr_type() {
		
	}
	
	@Test
	public void should_not_add_new_computer_with_wrong_mhr() {
		
	}
	
	@Test
	public void should_not_add_new_computer_with_wrong_memory_size() {
		
	}
}
