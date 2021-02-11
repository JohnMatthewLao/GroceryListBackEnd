package com.example.controller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class ItemController {
	
	private GroceryListService glServ;
	private ItemService iServ;
	
	@PostMapping(value="/grocery-lists/items")
	public ResponseEntity<String> insertItem(@RequestBody LinkedHashMap<String,String> fMap) {
		System.out.println("i am here");
		String categoryName = fMap.get("categoryName");
		String itemName = fMap.get("itemName");
		int quantity = Integer.parseInt(fMap.get("quantity"));
		
		GroceryList gl = glServ.getGroceryListByCategoryName(categoryName);
		/*
		 * { "username": "john", "firstName": "john", "lastName": "lao", "address":
		 * "Santa Paula", "age": "10", "emailAddress": "laojohnmatthew@gmail.com",
		 * "contactNumber": "2246237364" }
		 */
		
		Item item = new Item(itemName, quantity, gl);
		iServ.insert(item);
		return new ResponseEntity<>("resource was created", HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="/grocery-lists/items/{itemId}")
	public ResponseEntity<Item> deleteItemByItemName(@PathVariable("itemId") String itemId){
		Item i = iServ.getItemById(Integer.parseInt(itemId));
		if(i == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		iServ.deleteItem(i);
		return new ResponseEntity<>(i, HttpStatus.OK);
	} 
}
