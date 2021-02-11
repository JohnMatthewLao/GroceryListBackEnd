package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.GroceryList;
import com.example.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

	public List<Item> findAll();
	public List<Item> findByGroceryListHolder(GroceryList groceryListHolder);
	public Item findByItemId(int Id);
	
}



