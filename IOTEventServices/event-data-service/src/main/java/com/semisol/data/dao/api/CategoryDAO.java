package com.semisol.data.dao.api;

import java.util.List;
import java.util.UUID;

import org.springframework.context.annotation.Configuration;

import com.semisol.data.domain.Category;

@Configuration
public interface CategoryDAO {

	boolean addCategoryInfo(Category category);

	boolean updateCategoryInfo(Category category);

	boolean deleteCategoryInfo(Category category);

	List<Category> getAllCategories();

	Category findCategoryById(UUID categoryId);
}
