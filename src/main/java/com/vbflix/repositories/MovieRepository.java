package com.vbflix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vbflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	List<Movie> findByTitleStartsWith(String title);
	
	List<Movie> findByMainActor(String mainActor);
}
