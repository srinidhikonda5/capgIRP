package com.capg.bank.model;

public class Account {
	private int accountNumber;
	private long amount;

	public Account() {
		super();
	}

	public Account(int accountNumber, long amount) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", amount=" + amount + "]";
	}

}
