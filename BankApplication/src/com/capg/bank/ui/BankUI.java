package com.capg.bank.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capg.bank.exceptions.InsufficientBalanceException;
import com.capg.bank.exceptions.InsufficientOpeningBalanceException;
import com.capg.bank.exceptions.InvalidAccountNumberException;
import com.capg.bank.model.Account;
import com.capg.bank.service.BankServiceImpl;
import com.capg.bank.service.IBankService;

public class BankUI {

	public static Scanner scanner;

	public static IBankService service = new BankServiceImpl();

	public static void main(String[] args) throws Exception {

		do {

			System.out.println("1. Add account");
			System.out.println("2. Deposit Amount");
			System.out.println("3. Get Account");
			System.out.println("4. Withdraw Amount");
			System.out.println("5. Amount Transfer ");
			System.out.println("5. Exit");
			int input = 0;
			boolean inputFlag = false;

			int count = 0;

			do {
				scanner = new Scanner(System.in);

				if (count > 2) {
					System.exit(0);
				}
				System.out.println("enter the input");
				try {
					input = scanner.nextInt();
					if (input == 1 || input == 2 || input == 3 || input == 4 || input == 5) {
						inputFlag = true;
					} else {
						inputFlag = false;
						System.err.println("Please enter valid option");
					}
				} catch (InputMismatchException e) {
					inputFlag = false;
					count++;
					System.err.println("input should contain only digits");
				}

			} while (!inputFlag);

			switch (input) {
			case 1:
				addAccount();
				break;
			case 2:
				depositAmount();
				break;
			case 3:
				getAccount();
				break;
			case 4:
				withdrawAmount();
				break;
			case 5:
				transferAmount();
				break;
			case 6: {
				System.out.println("Thank you");
				System.exit(0);
			}
				;
			}

		} while (true);

	}

	static void addAccount() throws InsufficientOpeningBalanceException {
		scanner = new Scanner(System.in);
		Account account = new Account();
		System.out.println("Enter Account Number : ");
		account.setAccountNumber(scanner.nextInt());
		if (service.getAccountByAccountNumber(account.getAccountNumber()) != null) {
			System.err.println("Account on this number already exist");
		} else {
			System.out.println("Enter Balance : ");
			account.setAmount(scanner.nextLong());
			try {
				if (account.getAmount() < 500) {
					throw new InsufficientOpeningBalanceException("Insufficient Opening Balance Exception");
				} else {
					service.addAccount(account);
					System.out.println("Account added Successfully");
				}
			} catch (InsufficientOpeningBalanceException e) {
				System.err.println(e.getMessage());
			}

		}

	}

	private static void depositAmount() throws InvalidAccountNumberException {
		System.out.println("Enter Account Number : ");
		int accountNumber = scanner.nextInt();
		Account account = service.getAccountByAccountNumber(accountNumber);
		try {
			if (account != null) {
				System.out.println("Enter the Amount to deposit : ");
				long deposit = scanner.nextLong();
				long c;
				c = account.getAmount() + deposit;
				account.setAmount(c);
				System.out.println("Balance after deposit " + account.getAmount());

			} else {
				throw new InvalidAccountNumberException("Account not found");
			}
		} catch (InvalidAccountNumberException e) {
			System.err.println(e.getMessage());
		}
	}

	static void getAccount() throws InvalidAccountNumberException {
		scanner = new Scanner(System.in);
		System.out.println("Enter Account Number : ");
		int accountNumber = scanner.nextInt();
		Account account = service.getAccountByAccountNumber(accountNumber);
		try {
			if (account != null) {

				System.out.println("Account Details");
				System.out.println("-----------------------------------");
				System.out.println("Account Number               " + account.getAccountNumber());
				System.out.println("Amount                      " + account.getAmount());
			} else {
				throw new InvalidAccountNumberException("Account not found");
			}
		} catch (InvalidAccountNumberException e) {
			System.err.println(e.getMessage());
		}

	}

	private static void withdrawAmount() throws InvalidAccountNumberException, InsufficientBalanceException {
		System.out.println("Enter Account Number : ");
		int accountNumber = scanner.nextInt();
		Account account = service.getAccountByAccountNumber(accountNumber);
		try {
			if (account != null) {
				System.out.println("Enter Withdrawal Amount : ");
				long withdrawal = scanner.nextLong();
				if (account.getAmount() < withdrawal) {
					throw new InsufficientBalanceException("Insufficient balance");
				} else {
					long d;
					d = account.getAmount() - withdrawal;
					account.setAmount(d);
					System.out.println("Balance left in Account " + account.getAmount());
				}

			} else {
				throw new InvalidAccountNumberException("Account not found");
			}
		} catch (InvalidAccountNumberException e) {
			System.err.println(e.getMessage());
		} catch (InsufficientBalanceException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void transferAmount() throws InvalidAccountNumberException, InsufficientBalanceException {
		System.out.println("Enter Your Account Number : ");
		int accountNumber1 = scanner.nextInt();
		Account account = service.getAccountByAccountNumber(accountNumber1);
		try {
			if (account != null) {
				System.out.println("Enter the Account Number to whom you want to transfer: ");
				int accountNumber2 = scanner.nextInt();
				Account account1 = service.getAccountByAccountNumber(accountNumber2);
				if (account1 != null) {
					System.out.println("Enter the amount to be transferred : ");
					long transfer = scanner.nextLong();
					if (account.getAmount() < transfer) {
						throw new InsufficientBalanceException("Insufficient balance");
					} else {
						long d;
						long c;
						d = account.getAmount() - transfer;
						c = account1.getAmount() + transfer;
						account.setAmount(d);
						account1.setAmount(c);
						System.out.println("Balance left in your Account after tranferring " + account.getAmount());
					}
				} else {
					throw new InvalidAccountNumberException("Account not found");
				}

			} else {
				throw new InvalidAccountNumberException("Account not found");
			}
		} catch (InvalidAccountNumberException e) {
			System.err.println(e.getMessage());
		} catch (InsufficientBalanceException e) {
			System.err.println(e.getMessage());
		}

	}

}
