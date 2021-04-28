package com.capg.bank.dao;

import java.util.ArrayList;
import java.util.List;

import com.capg.bank.model.Account;

public class BankDAOImpl implements IBankDAO {

	private List<Account> accountList = new ArrayList<Account>();

	public BankDAOImpl() {
		Account account1 = new Account(111, 8000);
		Account account2 = new Account(112, 9000);
		Account account3 = new Account(113, 1000);
		Account account4 = new Account(114, 1500);

		accountList.add(account1);
		accountList.add(account2);
		accountList.add(account3);
		accountList.add(account4);

	}

	@Override
	public void addAccount(Account account) {
		accountList.add(account);
	}

	@Override
	public Account getAccountByAccountNumber(Integer accountnumber) {
		Account account1 = null;
		for (Account account : accountList) {
			if (account.getAccountNumber() == accountnumber) {
				account1 = account;
			}
		}
		return account1;
	}

}
