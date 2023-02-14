package model.entities;

import model.exception.DomainExceptions;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {		
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void deposit(double amount) throws DomainExceptions{
					
		this.balance += amount;
	}
	
	public void withdraw(double amount) throws DomainExceptions{
		if(amount > getWithdrawLimit())
		{
			throw new DomainExceptions("Withdraw error: The amount exceeds withdraw limit");
		}
		else if(amount > getBalance())
		{
			throw new DomainExceptions("Withdraw error: Not enough balance");
		}
		else 
		{			
			this.balance -=amount;
		}
	}
	
	
}
