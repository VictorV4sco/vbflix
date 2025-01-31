package com.vbflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vbflix.dto.MovieDTO;
import com.vbflix.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@GetMapping(value = "/{id}")
	public MovieDTO findById(@PathVariable Long id) {	//Criando método para retornar objeto MovieDTO
		return service.findById(id);
	}
}
