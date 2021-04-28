package com.capg.bank.service;

import com.capg.bank.model.Account;

public interface IBankService {

	void addAccount(Account account);

	Account getAccountByAccountNumber(Integer accountnumber);
}
