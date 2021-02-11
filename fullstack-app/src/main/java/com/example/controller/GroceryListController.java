package com.example.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.GroceryList;
import com.example.model.Item;
import com.example.service.GroceryListService;
import com.example.service.ItemService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor(onConstructor=@__(@Autowired))
@CrossOrigin(origins="http://localhost:4200")
@NoArgsConstructor
public class GroceryListController {
	
	private GroceryListService glServ;
	
	@PostMapping(value="/grocery-lists")
	public ResponseEntity<String> insertList(@RequestBody LinkedHashMap<String,String> fMap) {
		String categoryName = fMap.get("categoryName");
		
		/*
		 * { "username": "john", "firstName": "john", "lastName": "lao", "address":
		 * "Santa Paula", "age": "10", "emailAddress": "laojohnmatthew@gmail.com",
		 * "contactNumber": "2246237364" }
		 */
		
		GroceryList gl = new GroceryList(categoryName);
		glServ.insertCategoryList(gl);
		return new ResponseEntity<>("resource was created", HttpStatus.CREATED);
	}
	
	@GetMapping(value="/grocery-lists")
	public ResponseEntity<List<GroceryList>> getAllGroceryLists() {
		List<GroceryList> glList = glServ.getAllGroceryList();
		if(glList.size() == 0) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(glList, HttpStatus.OK);
	}
	
	@GetMapping(value="/grocery-lists/{categoryName}")
	public ResponseEntity<String> getGroceryListByCategoryName(@RequestBody LinkedHashMap<String,String> fMap) {
		String categoryName = fMap.get("categoryName");
		if(categoryName == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		glServ.deleteCategoryListByName(categoryName);
		return new ResponseEntity<>(categoryName, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/grocery-lists")
	public ResponseEntity<GroceryList> deleteGroceryListByCategoryName(@RequestBody LinkedHashMap<String,String> fMap) {
		System.out.println("this is fmap" + fMap);
		String categoryName = fMap.get("categoryName");
		GroceryList gl = glServ.getGroceryListByCategoryName(categoryName);
		if(gl == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		glServ.deleteCategoryList(gl);
		return new ResponseEntity<>(gl, HttpStatus.OK);
	} 
	

	
	
	

}
