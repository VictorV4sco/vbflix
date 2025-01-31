package com.vbflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbflix.dto.CategoryDTO;
import com.vbflix.entities.Category;
import com.vbflix.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public CategoryDTO findById(Long id) {
		Category entity = repository.findById(id).get();
		CategoryDTO dto = new CategoryDTO(entity);
		return dto;
	}
}
