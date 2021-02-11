package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.GroceryList;
import com.example.repository.GroceryListRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class GroceryListService {

//	private TransactionService tService;
	private GroceryListRepository groceryListRepository;

	public GroceryList getGroceryListByCategoryName(String name) { // change back to string later
		
		return groceryListRepository.findByCategoryName(name);
	}
	
	public List<GroceryList> getAllGroceryList() { // change back to string later
		
		return groceryListRepository.findAll();
	}

	// return type??
//	public ClientUser getAccountsByUsername(String username){
//		return accountRepository.findByUsername(username);
//	}
//	
	
	public void insertCategoryList(GroceryList groceryList) {
		groceryListRepository.save(groceryList);
	}
	
	public void deleteCategoryListByName(String categoryName) {
		groceryListRepository.deleteByCategoryName(categoryName);
	}
	
	public void deleteCategoryList(GroceryList groceryList) {
		groceryListRepository.delete(groceryList);
	}
	
	

//	public void transferFunds(String accNumFrom, String accNumTo, double amount) {
//		System.out.println("in the transfer methods");
//		Account from = getAccountByAccountNumber(accNumFrom);
//		Account to = getAccountByAccountNumber(accNumTo);
//		if (from == null || to == null) {
//		} else {
//			if (from.getBalance() - amount < 0.00) {
//				System.out.println("Overdraft fees will be applied");
//			} else {
//				System.out.println("Initiating fund transfer");
//				
//				from.setTransList(tService.getAllTransactionsByClientId(accNumFrom));
//				to.setTransList(tService.getAllTransactionsByClientId(accNumTo));
//				from.setBalance(from.getBalance() - amount);
//				List<Transaction> fTr = from.getTransList();
//				if (fTr.size() == 0) {
//					Transaction amountWithdrawn = new Transaction(
//							"Transfer of money from " + from.getTHolder().getTypeName() + " to "
//									+ to.getTHolder().getTypeName(),
//							new Timestamp(System.currentTimeMillis()), -amount, 0, from);
//					fTr.add(amountWithdrawn);
//					tService.insert(amountWithdrawn);
//				} else {
//
//					Transaction amountWithdrawn = new Transaction(
//							"Transfer of money from " + from.getTHolder().getTypeName() + " to "
//									+ to.getTHolder().getTypeName(),
//							new Timestamp(System.currentTimeMillis()), -amount, 0, from);
//					fTr.add(amountWithdrawn);
//					tService.insert(amountWithdrawn);
//				}
//				accountRepository.save(from);
//				to.setBalance(to.getBalance() + amount);
//				Transaction amountDeposited = new Transaction(
//						"Transfer of money from " + from.getTHolder().getTypeName() + " to "
//								+ to.getTHolder().getTypeName(),
//						new Timestamp(System.currentTimeMillis()), amount, 0, to);
//				List<Transaction> tTr = to.getTransList();
//				if (tTr.size() == 0) {
//
//					tTr.add(amountDeposited);
//					tService.insert(amountDeposited);
//				} else {
//					tTr.add(amountDeposited);
//				}
//				accountRepository.save(to);
//			}
//		}
//	}
}
