package com.vbflix.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbflix.dto.MovieDTO;
import com.vbflix.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;
	
	public Optional<MovieDTO> findById(Long id) {
		return repository.findById(id)
				.map(movie -> new MovieDTO(movie.getId(), movie.getTitle(), movie.getDescription(), movie.getCategory(),
						movie.getDirector(), movie.getMainActor(), movie.getReleaseDate()));
	}
}