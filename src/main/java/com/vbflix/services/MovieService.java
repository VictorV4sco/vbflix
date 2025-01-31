package com.vbflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbflix.dto.MovieDTO;
import com.vbflix.entities.Movie;
import com.vbflix.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;
	
	public MovieDTO findById(Long id) {
		Movie entity = repository.findById(id).get();
		MovieDTO dto = new MovieDTO(entity);
		return dto;
	}
}
