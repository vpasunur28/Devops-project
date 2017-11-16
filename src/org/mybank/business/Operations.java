package org.mybank.business;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.mybank.entities.Account;
import org.mybank.entities.Savings;

public class Operations {
	// withdraw specified amount from the specified account number
	public void withdrawl(BigInteger accNum, BigDecimal amount) throws Exception {
		Account acc = findAccount(accNum);
		if (acc!=null) { // check if it is valid account
			if (acc.getBalance().floatValue() >= amount.floatValue()) {
				if (acc.getType().equals("SAVINGS")) { // if savings account. 
					Savings savingsAccount = getSavingsAccount(acc.getAccountNumber());
					if (savingsAccount.getSavingsType().equals("INDIVIDUAL") && amount.floatValue() > 1000) {
						throw new Exception("Idividual account cannot withdraw amount more than 1000.");
					} else {
						
						// create a transaction here
						acc.setBalance(new BigDecimal(acc.getBalance().floatValue() - amount.floatValue()));
					}
				}
			} else {
				throw new Exception("Insufficient funds");
			} 
		}else{
			throw new Exception("Invalid Account");
		}
		
	}
	
	//returns saving acc based on account number
	private Savings getSavingsAccount(BigInteger accountNumber) {
		return new Savings();

	}
	
	// returns account based on account number
	private Account findAccount(BigInteger accNum) {
		// TODO Auto-generated method stub

		return new Account();
	}

	// transfers funds from source to destination. 
	public void transfer(BigInteger sourceAccNum, BigInteger destAccNum, BigDecimal amount) throws Exception {
		Account src = findAccount(sourceAccNum);
		Account dest = findAccount(destAccNum);
		if(src!=null && dest!=null){
			if(src.getBalance().floatValue()>amount.floatValue()){
				// create a new trascation instance here
				src.setBalance(new BigDecimal(src.getBalance().floatValue() - amount.floatValue()));
				dest.setBalance(new BigDecimal(dest.getBalance().floatValue() + amount.floatValue()));
			}else{
				throw new Exception("Insufficient funds");
			}
		}else{
			throw new Exception("Invalid account.");
		}
	}
	// deposit amount in specified account. 
	public void deposit(BigInteger accNum, BigDecimal amount) throws Exception {
		Account acc = findAccount(accNum);
		if(acc!=null){
			// create a new trascation instance here
			acc.setBalance(new BigDecimal(acc.getBalance().floatValue() + amount.floatValue()));
		}else{
			throw new Exception("Invalid Account");
		}
	}
}
