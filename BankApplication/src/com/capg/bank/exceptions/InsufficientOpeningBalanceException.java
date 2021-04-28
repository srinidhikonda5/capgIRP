package com.capg.bank.exceptions;

public class InsufficientOpeningBalanceException extends Exception {

	public InsufficientOpeningBalanceException(String message) {
		super(message);
	}
}
