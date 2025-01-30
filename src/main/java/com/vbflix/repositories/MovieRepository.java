package com.vbflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vbflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
