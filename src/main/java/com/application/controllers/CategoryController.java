package com.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.entities.Category;
import com.application.services.CategoryService;
import com.application.services.dto.CategoryDto;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class CategoryController {

	@Autowired
	CategoryService service;

	@GetMapping("/categories")
	public ResponseEntity <List<Category>> getCategory(){
		List<Category> categories= service.findAllCategories();
		return ResponseEntity.ok().body(categories);
	}


	@PostMapping("/categories")
	public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto category){
		Category category1 = new Category(category.getType());
		CategoryDto category2= service.saveCategory(category1);
		return ResponseEntity.status(HttpStatus.CREATED).body(category2);
	}

	@GetMapping("/categories/{idcategory}")
	public ResponseEntity<Category> getCategoryId(@PathVariable("idcategory") Long idcategory){
		return ResponseEntity.ok(service.findByIdCategory(idcategory));
	}

//I add a comment here

//And an other one because I wanted

    @PutMapping("/categories/{idcategory}")//this one as well, that 's not the original one'
    //Should I set a comment here ? maybe not
    //let's commit before to fixed
    //adding a comment again
	public ResponseEntity<CategoryDto> updateCategory(@PathVariable("idcategory") Long idcategory, @RequestBody CategoryDto categoryDto){
		Category category = new Category(categoryDto.getType());
		return ResponseEntity.ok(service.updateCategory(idcategory, category));//that's not the original lines
	}


	@DeleteMapping("/categories/{idcategory}")
	public ResponseEntity<Category> deleteCategory(@PathVariable("idcategory") Long idcategory){
		service.deleteCategory(idcategory);
		return ResponseEntity.noContent().build();
	}
}


// @PutMapping("/categories/{idcategory}")
// 	public ResponseEntity<CategoryDto> updateCategory(@PathVariable("idcategory") Long idcategory, @RequestBody CategoryDto category){
//        Category category = new Category(categoryDto.getType())
// 		return ResponseEntity.ok(service.updateCategory(idcategory, category));
// 	}