package com.vbflix.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbflix.dto.MovieDTO;
import com.vbflix.entities.Movie;
import com.vbflix.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	public MovieDTO findById(Long id) throws Exception {
		try {
			Movie movie = repository.findById(id).orElseThrow(() -> new Exception("Teste"));
			if(movie.getId() == 1) {
				new RuntimeException("Deu zica");
			}
			return new MovieDTO(movie.getId(), movie.getTitle(), movie.getDescription(), movie.getCategory(),
					movie.getDirector(), movie.getMainActor(), movie.getReleaseDate());
		} catch (Exception e) { // Erros com mesmo tratamento aqui dentro
			throw e;
		}
	}
	
	public List<MovieDTO> findByTitle(String title) throws Exception {
		try {
			List<Movie> movies = repository.findByTitle(title);
			if(movies.isEmpty()) {
				throw new Exception("Título não encontrado");
			}
			return movies.stream().map(movie -> new MovieDTO(movie.getId(), movie.getTitle(), movie.getDescription(), movie.getCategory(),
					movie.getDirector(), movie.getMainActor(), movie.getReleaseDate())).collect(Collectors.toList()) ;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public List<MovieDTO> findVByActor(String mainActor) throws Exception {
		try {
			List<Movie> movies = repository.findByMainActor(mainActor);
			if(movies.isEmpty()) {
				throw new Exception("Ator não listado");
			}
			return movies.stream().map(movie -> new MovieDTO(movie.getId(), movie.getTitle(), movie.getDescription(), movie.getCategory(),
					movie.getDirector(), movie.getMainActor(), movie.getReleaseDate())).collect(Collectors.toList()) ;
		} catch (Exception e) {
			throw e;
		}
	}
	
}