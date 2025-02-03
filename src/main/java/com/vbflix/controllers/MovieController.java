package com.vbflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<MovieDTO> getMovieById(@PathVariable Long id) throws Exception {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@GetMapping(value = "/title/{title}")
	public ResponseEntity<List<MovieDTO>> getMovieByTitle(@PathVariable String title) throws Exception {
		List<MovieDTO> result = service.findByTitle(title);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/actors/{mainActor}")
	public ResponseEntity<List<MovieDTO>> getMovieByActor(@PathVariable String mainActor) throws Exception {
		List<MovieDTO> result = service.findVByActor(mainActor);
		return ResponseEntity.ok(result);
	}
}
