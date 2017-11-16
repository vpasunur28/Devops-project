package org.mybank.entities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
// Generic Account
public class Account {
	
	private String type;
	private String ownerName;
	private BigDecimal balance;
	private BigInteger accountNumber;
	private Date startDate;
	private Boolean active;
	
	
	
	public BigInteger getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(BigInteger accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOwner() {
		return ownerName;
	}
	public void setOwner(String owner) {
		this.ownerName = owner;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	
}
