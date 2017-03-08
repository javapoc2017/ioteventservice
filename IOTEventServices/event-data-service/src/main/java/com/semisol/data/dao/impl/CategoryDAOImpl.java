package com.semisol.data.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.semisol.data.dao.api.CategoryDAO;
import com.semisol.data.domain.Category;
import com.semisol.data.repository.CategoryRepository;

@Configuration
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public boolean addCategoryInfo(Category category) {
		try {
			categoryRepository.save(category);
		} catch (Exception ex) {
			return false;
		}
		return true;

	}

	@Override
	public boolean updateCategoryInfo(Category category) {
		try {
			//categoryRepository.update(category);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCategoryInfo(Category category) {
		try {
			categoryRepository.delete(category);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public List<Category> getAllCategories() {
		return (List<Category>) categoryRepository.findAll();
	}

	@Override
	public Category findCategoryById(UUID categoryId) {
		return categoryRepository.findByCatId(categoryId);
	}

}
