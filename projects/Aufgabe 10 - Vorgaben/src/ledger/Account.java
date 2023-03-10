package ledger;

import exceptions.AccountClosedException;
import exceptions.AmountInsufficientException;

public abstract class Account {
	
	private String name;	
	private boolean open = false;
	protected int value = 5000;
	protected int delta = 0;

	public Account(String name) {
		this.name = name;
	}
	
	public abstract void credit(int value)
			throws AmountInsufficientException, AccountClosedException;
	
	public abstract void debit (int value)
			throws AmountInsufficientException, AccountClosedException;
	
	public void open() {
		this.open = true;
	}
	
	public void abort() {
		delta = 0;
	}
	
	public void commit() {
		value += delta;
		delta = 0;
	}
	
	public void close() {
		this.open = false;
	}
	
	public boolean isOpen() {
		return open;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {		
		return name + " (value=" + value + ", open=" + open + ")";
	}

}
