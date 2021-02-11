package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.GroceryList;
import com.example.model.Item;
import com.example.repository.GroceryListRepository;
import com.example.repository.ItemRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor 
public class ItemService {
	
	private GroceryListRepository groceryListRepo;
	private ItemRepository itemRepository;
	
	public void insert(Item i)
	{
		itemRepository.save(i);
	}
	
	public List<Item> getAllItemsByCategoryName(String name) {
		GroceryList gl = groceryListRepo.findByCategoryName(name);
		//System.out.println(a);
		return itemRepository.findByGroceryListHolder(gl);
	}
	
	public Item getItemById(int id) {
		//System.out.println(a);
		return itemRepository.findByItemId(id);
	}
	
	public Item insertItem(Item i) {
		itemRepository.save(i);
		//System.out.println(a);
		return i;
	}
	
	public Item deleteItem(Item i) {
		itemRepository.delete(i);
		//System.out.println(a);
		return i;
	}
	
//	public Account getAccountsByUsername(String accountNumber){
//		return transactionRepository.findByAccountNumber(accountNumber);
//	}
	
}

