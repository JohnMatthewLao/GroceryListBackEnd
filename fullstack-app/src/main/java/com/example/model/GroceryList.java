package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="GroceryList")
public class GroceryList {
	@Id
    @Column(name = "grocery_list_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
    private int groceryListid; //change back to string later
	
	@Column(name="category_name", unique = true)
	private String categoryName;
	
	@OneToMany(mappedBy="groceryListHolder", fetch=FetchType.EAGER)
	private List<Item> itemList = new ArrayList<>();

	
	public GroceryList(String categoryName) {
		super();
		this.categoryName = categoryName;
	}


	public GroceryList(String categoryName, List<Item> itemList) {
		super();
		this.categoryName = categoryName;
		this.itemList = itemList;
	}

	
	@Override
	public String toString() {
		return "GroceryList [groceryListid=" + groceryListid + "]";
	}

	 
	
}

