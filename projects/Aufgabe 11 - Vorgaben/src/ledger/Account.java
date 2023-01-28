package ledger;

import exceptions.AccountException;
import exceptions.AccountLockedException;

public abstract class Account {
	
	private String name;	
	private boolean open = false;
	protected int value = 5000;
	protected int delta = 0;

	private Accountant accountant = null;
	public Account(String name) {
		this.name = name;
	}
	
	public abstract void credit(int value) throws AccountException;
	
	public abstract void debit(int value) throws AccountException;

	public boolean isLockedByAccountant(Accountant accountant) {
		if(this.accountant == null)
			return false;

		return this.accountant == accountant;
	}

	public boolean open(Accountant accountant) throws AccountLockedException {
		if ((this.accountant == null && !this.open)) {
			this.open = true;
			this.accountant = accountant;
			return true;
		}

		throw new AccountLockedException("This account is already locked by other Accountant.");
	}
	
	public void abort() {
		this.accountant = null;
		delta = 0;
	}
	public boolean commit() {
		if (isLockedByAccountant(accountant)) {
			value += delta;
			delta = 0;
			return true;
		}

		return false;
	}
	
	public void close() {
		if (isLockedByAccountant(accountant)) {
			this.accountant = null;
		}

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
