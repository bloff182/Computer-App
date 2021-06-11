package com.bloff.computerapp.exception;

public class ComputerNotFoundException extends RuntimeException {

	public ComputerNotFoundException(Long id) {
		super("Computer does not exist by id = " + id);
	}
}
