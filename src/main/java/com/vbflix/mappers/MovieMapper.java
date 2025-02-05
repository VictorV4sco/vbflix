package com.vbflix.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.vbflix.dto.MovieDTO;
import com.vbflix.entities.Movie;

@Mapper
public interface MovieMapper {
	
	MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
	
	MovieDTO toDTO(Movie movie);
	Movie toEntity(MovieDTO movieDTO);

}
