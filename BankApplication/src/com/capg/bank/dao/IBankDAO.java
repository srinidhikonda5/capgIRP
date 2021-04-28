package com.capg.bank.dao;

import com.capg.bank.model.Account;

public interface IBankDAO {

	void addAccount(Account account);

	Account getAccountByAccountNumber(Integer accountnumber);

}
