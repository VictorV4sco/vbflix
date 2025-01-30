package com.vbflix.dto;

import com.vbflix.entities.Category;
import com.vbflix.entities.Movie;

public class MovieDTO {

	private Long id;
	private String shortDescription;
	private Category category;

	public MovieDTO() {
	}

	public MovieDTO(Long id, String shortDescription, Category category) {
		this.id = id;
		this.shortDescription = shortDescription;
		this.category = category;
	}

	public MovieDTO(Movie movie) {
		id = movie.getId();
		shortDescription = movie.getShortDescription();
		category = movie.getCategory();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
