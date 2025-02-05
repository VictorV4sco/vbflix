package com.vbflix.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbflix.dto.MovieDTO;
import com.vbflix.entities.Movie;
import com.vbflix.mappers.MovieMapper;
import com.vbflix.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	public MovieDTO findById(Long id) throws Exception {
		try {
			Movie movie = repository.findById(id).orElseThrow(() -> new Exception("Teste"));
			if (movie.getId() == 1) {
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
			List<Movie> movies = repository.findByTitleStartsWith(title);
			if (movies.isEmpty()) {
				throw new Exception("Título não encontrado");
			}
			return movies.stream()
					.map(movie -> new MovieDTO(movie.getId(), movie.getTitle(), movie.getDescription(),
							movie.getCategory(), movie.getDirector(), movie.getMainActor(), movie.getReleaseDate()))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw e;
		}
	}

	public List<MovieDTO> findVByActor(String mainActor) throws Exception {
		try {
			List<Movie> movies = repository.findByMainActor(mainActor);
			if (movies.isEmpty()) {
				throw new Exception("Ator não listado");
			}
			return movies.stream()
					.map(movie -> new MovieDTO(movie.getId(), movie.getTitle(), movie.getDescription(),
							movie.getCategory(), movie.getDirector(), movie.getMainActor(), movie.getReleaseDate()))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw e;
		}
	}

	public List<MovieDTO> findAllMovies() throws Exception {
		try {
			List<Movie> movies = repository.findAll();
			if (movies.isEmpty()) {
				throw new Exception("Lista está vazia");
			}
			return movies.stream()
					.map(movie -> new MovieDTO(movie.getId(), movie.getTitle(), movie.getDescription(),
							movie.getCategory(), movie.getDirector(), movie.getMainActor(), movie.getReleaseDate()))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw e;
		}
	}
	
//	public MovieDTO save(MovieDTO movieDTO) {
//        // Convertendo DTO para entidade manualmente
//        Movie movie = new Movie();
//        movie.setTitle(movieDTO.title());
//        movie.setDescription(movieDTO.description());
//        movie.setCategory(movieDTO.category());
//        movie.setDirector(movieDTO.director());
//        movie.setMainActor(movieDTO.mainActor());
//        movie.setReleaseDate(movieDTO.releaseDate());
//
//        // Salvando no banco
//        Movie savedMovie = repository.save(movie);
//
//        // Convertendo entidade salva de volta para DTO e retornando
//        return new MovieDTO(
//            savedMovie.getId(),
//            savedMovie.getTitle(),
//            savedMovie.getDescription(),
//            savedMovie.getCategory(),
//            savedMovie.getDirector(),
//            savedMovie.getMainActor(),
//            savedMovie.getReleaseDate()
//        );
//    }
	
	public MovieDTO saveMovie(MovieDTO movieDTO) {
		Movie movie = MovieMapper.INSTANCE.toEntity(movieDTO); // Converte UsuarioDTO para Usuario (entidade)
		Movie savedMovie = repository.save(movie);	// Salva a entidade no banco de dados
		return MovieMapper.INSTANCE.toDTO(savedMovie);	// Converte a entidade salva de volta para UsuarioDTO
	}
	
	public void excludeMovieById(Long id) {
		repository.deleteById(id);
	}
}