package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.GroceryList;

@Repository
public interface GroceryListRepository extends JpaRepository<GroceryList, Integer>{

	public List<GroceryList> findAll();
	
	public GroceryList findByCategoryName (String categoryName);
	
	public GroceryList deleteByCategoryName (String categoryName);
	
	
}

