package com.vbflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		return new ResponseEntity<>(service.findByTitle(title), HttpStatus.OK);
	}
	
	@GetMapping(value = "/actors/{mainActor}")
	public ResponseEntity<List<MovieDTO>> getMovieByActor(@PathVariable String mainActor) throws Exception {
		return new ResponseEntity<>(service.findVByActor(mainActor), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<MovieDTO>> findAllMovies() throws Exception {
		return new ResponseEntity<>(service.findAllMovies(), HttpStatus.OK);
	}
	
//	@PostMapping
//	public ResponseEntity<MovieDTO> saveMovie(@RequestBody MovieDTO movieDTO) throws Exception {
//		MovieDTO savedMovie = service.save(movieDTO);
//		return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
//	}
	
	@PostMapping
	public ResponseEntity<MovieDTO> createUser(@RequestBody MovieDTO movieDTO) {
		MovieDTO savedUser = service.saveMovie(movieDTO);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> excludeMovieById(@PathVariable Long id) {
		service.excludeMovieById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
