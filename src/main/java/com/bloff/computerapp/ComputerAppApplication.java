package com.bloff.computerapp;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bloff.computerapp.model.Computer;
import com.bloff.computerapp.model.ComputerDto;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ComputerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComputerAppApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Computer, ComputerDto>() {
			@Override
			protected void configure() {
				map().setDdrType(source.getDdrType());
				map().setMhz(source.getMhz());
				map().setMemorySize(source.getMemorySize());
				map().setLocalDate(LocalDate.of(2021, 06, 10));
				map().setName("name");
			}
		});
        return modelMapper;
    }
}
