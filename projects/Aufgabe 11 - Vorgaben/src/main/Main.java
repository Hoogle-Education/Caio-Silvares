package main;

import ledger.AccountManager;
import ledger.Accountant;
import ledger.JournalEntryQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		AccountManager.init();
		JournalEntryQueue queue = new JournalEntryQueue(40);

		// not working
		// accountant.run

		List<Thread> accountants = createAccountants(2, queue)
				.stream().map(Thread::new).toList();
		accountants.forEach(Thread::start);

		System.out.println("# BATTERY OF TESTS");
		postEntries(queue, 100);

		long start = System.currentTimeMillis();

		while(accountants.stream().anyMatch(Thread::isAlive)){
			Thread.sleep(10);
		}

		long finish = System.currentTimeMillis();

		System.out.println("END OF PROGRAM");
		
	}

	private static ArrayList<Accountant> createAccountants(int numberOfAccountants, JournalEntryQueue queue) {
		Accountant[] accountantArray = new Accountant[numberOfAccountants];
		Arrays.fill(accountantArray, new Accountant(queue));
		return new ArrayList<Accountant>(List.of(accountantArray));
	}

	private static void postEntries(JournalEntryQueue queue, int numberOfEntries) throws InterruptedException {
		for (int i = 0; i < numberOfEntries; i++) {
			String entry = AccountManager.getRandomJournalEntry(4);
			System.out.println(entry);
			queue.add(entry);
			Thread.sleep(100);
		}
	}

}
