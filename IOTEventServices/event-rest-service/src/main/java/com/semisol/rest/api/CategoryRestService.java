package com.semisol.rest.api;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.semisol.iot.dto.CategoryDTO;
import com.semisol.iot.dto.RestResponse;
import com.semisol.service.api.AdminService;

@RestController
@RequestMapping(value = "/admin/category")
public class CategoryRestService {
	private static Logger logger = LoggerFactory.getLogger(CategoryRestService.class);

	@Autowired
	private AdminService adminService;

	@RequestMapping(method = RequestMethod.POST)
	public RestResponse addCategory(@RequestBody CategoryDTO categoryDTO) {
		boolean status = adminService.addCategoryInfo(categoryDTO);
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(status);
		return restResponse;
	}

	@RequestMapping(method = RequestMethod.PUT)
	public RestResponse updateCategory(@RequestBody CategoryDTO categoryDTO) {
		boolean status = adminService.updateCategoryInfo(categoryDTO);
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(status);
		return restResponse;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoryDTO>> getAllCategories() {
		List<CategoryDTO>	categories = adminService.getAllCategories();
		if (categories.isEmpty()) {
			logger.debug("categories does not exists");
			return new ResponseEntity<List<CategoryDTO>>(HttpStatus.NO_CONTENT);
		}
		logger.info("Found " + categories.size() + " categories");
		return new ResponseEntity<List<CategoryDTO>>(categories, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCategory(@PathVariable("id") UUID id) {
		CategoryDTO categoryDTO = adminService.findCategoryById(id);
		if (categoryDTO == null) {
			logger.info("CategoryDTO with id " + id + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			adminService.deleteCategoryInfo(categoryDTO);
			logger.info("CategoryDTO with id " + id + " deleted");
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CategoryDTO> getCategoryDetails(@PathVariable("id") UUID id) {
		CategoryDTO categoryDTO = adminService.findCategoryById(id);
		if (categoryDTO == null) {
			logger.info("CategoryDTO with id " + id + " does not exists");
			return new ResponseEntity<CategoryDTO>(HttpStatus.NOT_FOUND);
		}
		logger.info("Found CategoryDTO:: " + categoryDTO);
		return new ResponseEntity<CategoryDTO>(categoryDTO, HttpStatus.OK);
	}
}
