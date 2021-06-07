package com.bloff.computerapp.repositoryTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	    Exception exception = assertThrows(RuntimeException.class, () -> {
	    	repo.addComputer(new Computer("", 10L, 10));
	    });

	    String expectedMessage = "ddr type field can not be empty";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void should_not_add_new_computer_with_wrong_memory_size() {
		Exception exception = assertThrows(RuntimeException.class, () ->{
			repo.addComputer(new Computer("ddr", 10L, 0));
		});
		
		String expectedMessage = "Memory size must be greather than zero";
		String actualMessage = exception.getMessage();
		
		assertThat(actualMessage).isEqualTo(expectedMessage);
		
	}
	
	@Test
	public void should_not_add_new_computer_with_wrong_mhr() {
		Exception exception = assertThrows(RuntimeException.class, () ->{
			repo.addComputer(new Computer("ddr", -5L, 10));
		});
		
		String expectedMessage = "mhz must be greather than zero";
		String actualMessage = exception.getMessage();
		
		assertThat(actualMessage).isEqualTo(expectedMessage);
	}
	
	
}
