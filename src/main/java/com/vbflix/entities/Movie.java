package com.vbflix.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String title;
	
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	
	@Column
	private String category;
	
	@Column
	private String director;
	
	@Column(name = "main_actor")
	private String mainActor;
	
	@Column(name = "release_date")
	private String releaseDate;
	
	public Movie() {
	}

	public Movie(Long id, String title, String description, String category, String director, String mainActor,
			String releaseDate) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.director = director;
		this.mainActor = mainActor;
		this.releaseDate = releaseDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getMainActor() {
		return mainActor;
	}

	public void setMainActor(String mainActor) {
		this.mainActor = mainActor;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, description, director, id, mainActor, releaseDate, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(category, other.category) && Objects.equals(description, other.description)
				&& Objects.equals(director, other.director) && Objects.equals(id, other.id)
				&& Objects.equals(mainActor, other.mainActor) && Objects.equals(releaseDate, other.releaseDate)
				&& Objects.equals(title, other.title);
	}

	
}
