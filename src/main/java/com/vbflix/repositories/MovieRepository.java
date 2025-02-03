package com.vbflix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vbflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	List<Movie> findByTitle(String title);
	
	List<Movie> findByMainActor(String mainActor);
}
