package ledger;

import java.util.ArrayList;
import java.util.List;

import exceptions.*;
import util.Pair;


public class Accountant implements Runnable {

	private JournalEntryQueue queue;

	public Accountant(JournalEntryQueue queue){
		this.queue = queue;
	}

	public void postEntry(String journalEntry) throws InvalidJournalEntryException, AccountException {

		// nubank 20, inter 30; itau 40, bradesco 10
		// itau 40, inter 30; nubank 40, bradesco 10

		//check syntax and import 
		if (journalEntry.indexOf(";") == -1)
			throw new InvalidSyntaxException("Invalid syntax: ; missing in " + journalEntry);

		String[] debitCredit = journalEntry.split(";");

		if (debitCredit.length != 2)
			throw new InvalidSyntaxException("Invalid syntax: ; must split entry into two parts: " + journalEntry);
		
		List<Pair<Account, Integer>> debits = parseJournalEntry(debitCredit[0]);
		List<Pair<Account, Integer>> credits = parseJournalEntry(debitCredit[1]);
		
		//Ensure that debit value equals credit value
		int balance = 0;
		for (Pair<Account, Integer> p : debits) {
			balance += p.getSecond();
		}
		for (Pair<Account, Integer> p : credits) {
			balance -= p.getSecond();
		}

		if (balance != 0)
			throw new UnequalBalanceException("Unequal balance in: " + journalEntry);



		//Post entries
		AccountException error = null;
		try {
			//Open Accounts
			for (Pair<Account, Integer> p : debits) {
				p.getFirst().open(this);
			}
			for (Pair<Account, Integer> p : credits) {
				p.getFirst().open(this);
			}

			// Debit process
			for (Pair<Account, Integer> p : debits) {
				p.getFirst().debit(p.getSecond());
			}

			// Credit process
			for (Pair<Account, Integer> p : credits) {
				p.getFirst().credit(p.getSecond());
			}

			// Commit transactions
			commitTransaction(debits);
			commitTransaction(credits);
		
		} catch (AccountException e) {
			System.err.println("unable to post entry: " + e.getMessage());
			abortTransaction(debits);
			abortTransaction(credits);
			error = e;
		} finally {
			//Ensure that all accounts are closed
			for (Pair<Account, Integer> p : debits) {
				p.getFirst().close();
			}
			for (Pair<Account, Integer> p : credits) {
				p.getFirst().close();
			}
		}

		if (error != null) {
			throw error;
		}
	}

	private void abortTransaction(List<Pair<Account, Integer>> accounts) {
		for (Pair<Account, Integer> p : accounts) {
			p.getFirst().abort();
		}
	}

	private void commitTransaction(List<Pair<Account, Integer>> accounts) {
		for (Pair<Account, Integer> p : accounts) {
			p.getFirst().commit();;
		}
	}
	
	private List<Pair<Account, Integer>> parseJournalEntry(String debitOrCreditPart) throws InvalidSyntaxException, AccountNotFoundException {
		
		List<Pair<Account, Integer>> accountsAndValues = new ArrayList<>();
		
		for (String accountAndValue : debitOrCreditPart.split(",")) {
			accountAndValue = accountAndValue.trim();
			if (accountAndValue.indexOf(" ") == -1) { 
				throw new InvalidSyntaxException("Invalid syntax: account name and value must be splitted by a space in " + accountAndValue);
			}
			String[] parts = accountAndValue.split(" ");
			if (parts.length != 2) {
				throw new InvalidSyntaxException("Invalid syntax: spaces are not allowed in account names: " + accountAndValue);
			}
			String accountName = parts[0];
			try {
				Account account = AccountManager.getAccount(accountName);
				Integer value = Integer.parseInt(parts[1]);				
				accountsAndValues.add(new Pair<>(account, value));
			} catch (AccountNotFoundException e) {
				throw e;
			} catch (NumberFormatException e) {
				throw new InvalidSyntaxException("Invalid syntax: given value is not an integer number: " + parts[1]);
			}			
		}
		return accountsAndValues;
	}


	@Override
	public void run() {

		try{
			Thread.sleep(600);
		} catch (InterruptedException e) {
		}

		String entry = "";

		while( !queue.isEmpty() ) {
			try {
				entry = queue.getNext();
				if (entry.isEmpty())
					throw new EmptyEntryException("There are no more entries in cache!");

				System.err.println("ENTRY: " + entry);
				postEntry(entry);
			} catch (AccountLockedException lockedException) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) { }
				queue.add(entry);
			} catch (AccountException accountException) {
				System.err.println("ACCOUNT EXCEPTION: " + accountException.getMessage());
				queue.add(entry);
			} catch (InvalidJournalEntryException invalidException) {
				System.err.println("ENTRY EXCEPTION: " + invalidException.getMessage());
			}

			try{
				Thread.sleep(500);
			} catch (InterruptedException ignored) { }
		}


	}
}
