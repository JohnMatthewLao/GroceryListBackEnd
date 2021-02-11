package com.example.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="item")
public class Item {
	@Id
	@Column(name="item_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private int itemId;
	
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="quantity")
	private int quantity;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="groceryList_FK")
	@JsonIgnore
	private GroceryList groceryListHolder;
	
	
	public Item(String itemName, int quantity, GroceryList groceryListHolder) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
		this.groceryListHolder = groceryListHolder;
	}
	
	public Item(String itemName, GroceryList groceryListHolder) {
		super();
		this.itemName = itemName;
		this.groceryListHolder = groceryListHolder;
	}
	
	public Item(String itemName, int quantity) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", quantity=" + quantity + ", groceryListHolder="
				+ groceryListHolder + "]";
	}
	
	
}
