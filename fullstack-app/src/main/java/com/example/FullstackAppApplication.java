package com.example;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.GroceryList;
import com.example.repository.GroceryListRepository;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor

public class FullstackAppApplication implements ApplicationRunner{
	
	private GroceryListRepository glRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(FullstackAppApplication.class, args);
	}
	
	public void insertInitialValues(){
		
		glRepo.saveAll(Arrays.asList(
		          new GroceryList("meat"), new GroceryList("drinks")));
		    	//branchRepository.saveAll(Arrays.asList( new Branch("Santa Clara"), new Branch("Houston"), new Branch("San Francisco")));
		    	//accountTypeRepository.saveAll(Arrays.asList( new AccountType("checking"), new AccountType("saving")));
		    	GroceryList gl = new GroceryList("salad"); 
		    	glRepo.save(gl);
	};
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		insertInitialValues();

	}
}
