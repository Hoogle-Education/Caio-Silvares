package ledger;

import exceptions.*;
import util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Accountant {

	public void postEntry(String journalEntry) {

		List<Pair<Account, Integer>> debitList = new ArrayList<>();
		List<Pair<Account, Integer>> creditList = new ArrayList<>();
		//check syntax and import
		try {
			String[] data = journalEntry.split("; ");

			if(data.length != 2)
				throw new InvalidSyntaxException("Cannot resolve! Syntax exception.");

			String creditString = data[0];
			String debitString = data[1];

			String[] debitData = debitString.split(", ");
			String[] creditData = creditString.split(", ");


			parseAccountsAndValues(debitData, debitList);
			parseAccountsAndValues(creditData, creditList);

			//Ensure that debit value equals credit value
			Integer creditSum = sumValuesInList(creditList);
			Integer debitSum = sumValuesInList(debitList);
			if(!creditSum.equals(debitSum))
				throw new UnequalBalanceException("Cannot continue! Reason: Unequal balance.");

		} catch (AccountNotFoundException | InvalidSyntaxException | UnequalBalanceException exception) {
			System.out.println(exception.getMessage());
			return;
		}

		//Open Accounts
		openAccountsInList(creditList);
		openAccountsInList(debitList);

		//Post entries
		try {
			postDebitInAccountsInList(debitList);
			postCreditInAccountsInList(creditList);
			commitOperationsInAccountsInList(debitList);
			commitOperationsInAccountsInList(creditList);
		} catch (AmountInsufficientException | AccountClosedException exception) {
			System.out.println(exception.getMessage());
		}

		//Ensure that all accounts are closed
		closeAccountsInList(creditList);
		closeAccountsInList(debitList);
	}

	private void openAccountsInList(List<Pair<Account, Integer>> list) {
		list.forEach(p -> p.getFirst().open());
	}

	private void commitOperationsInAccountsInList(List<Pair<Account, Integer>> list) {
		list.forEach(p -> p.getFirst().commit());
	}

	private void closeAccountsInList(List<Pair<Account, Integer>> list) {
		list.forEach(p -> p.getFirst().close());
	}

	private void postDebitInAccountsInList(List<Pair<Account, Integer>> list)
			throws AmountInsufficientException, AccountClosedException {
		for(var p : list) {
			p.getFirst().debit(p.getSecond());
		}
	}

	private void postCreditInAccountsInList(List<Pair<Account, Integer>> list)
			throws AmountInsufficientException, AccountClosedException {
		for(var p : list) {
			p.getFirst().credit(p.getSecond());
		}
	}

	private Integer sumValuesInList(List<Pair<Account, Integer>> list) {
		return list
				.stream()
				.mapToInt(Pair::getSecond)
				.sum();
	}

	private void parseAccountsAndValues(String[] data, List<Pair<Account, Integer>> list)
			throws AccountNotFoundException, InvalidSyntaxException {

		for(String str : data) {
			String[] aux = str.split(" ");
			Account accountFounded = AccountManager.getAccount(aux[0]);
			Integer value;

			try {
				value = Integer.parseInt(aux[1]);
			} catch (NumberFormatException e) {
				throw new InvalidSyntaxException("Cannot resolve! Syntax exception.");
			}

			list.add(new Pair<>(accountFounded, value));
		}

	}

}
