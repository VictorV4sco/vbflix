package com.vbflix.dto;

public record MovieDTO(
		Long id, 
		String title, 
		String description, 
		String category, 
		String director, 
		String mainActor,
		String releaseDate) {

}
