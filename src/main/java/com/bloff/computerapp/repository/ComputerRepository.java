package com.bloff.computerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloff.computerapp.model.Computer;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long>{

}
