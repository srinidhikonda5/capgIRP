package com.capg.bank.service;

import com.capg.bank.dao.BankDAOImpl;
import com.capg.bank.dao.IBankDAO;
import com.capg.bank.model.Account;

public class BankServiceImpl implements IBankService {

	private IBankDAO dao = new BankDAOImpl();

	@Override
	public void addAccount(Account account) {
		dao.addAccount(account);
	}

	@Override
	public Account getAccountByAccountNumber(Integer accountnumber) {
		return dao.getAccountByAccountNumber(accountnumber);
	}

}
